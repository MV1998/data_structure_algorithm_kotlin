package leetcode_contest.bi_132

class FindFirstPlayerToWinKGamesInRow {
    fun findWinningPlayer(skills: IntArray, k : Int) : Int {
        var consecutiveWinningInRow = 0
        var winningPlayer = 0

        var highestSkillOfThePlayer = skills.maxOf{it->it}

        val dq = ArrayDeque<Int>()
        val map = mutableMapOf<Int, Int>()
        for(skill in skills) {
            dq.addLast(skill)
        }

        var player  = dq.first()

        while(k != consecutiveWinningInRow) {
            val p1 = dq.removeFirst()
            val p2 = dq.removeFirst()
            if (p1 > p2) {

                if(p1 == highestSkillOfThePlayer) {
                    winningPlayer = p1
                    break
                }

                dq.addFirst(p1)
                dq.addLast(p2)
                consecutiveWinningInRow = map.getOrDefault(p1, 0) + 1
                if (consecutiveWinningInRow < k) {
                    map[p1] = consecutiveWinningInRow
                }else {
                    winningPlayer = p1
                }
            }else {

                if(p2 == highestSkillOfThePlayer) {
                    winningPlayer = p2
                    break
                }

                dq.addFirst(p2)
                dq.addLast(p1)
                consecutiveWinningInRow = map.getOrDefault(p2, 0) + 1
                if (consecutiveWinningInRow < k) {
                    map[p2] = consecutiveWinningInRow
                }else {
                    winningPlayer = p2
                }
            }

        }
        return skills.indexOf(winningPlayer)
    }

    fun findHighestSkill(skills: IntArray):Int {
        var max = Int.MIN_VALUE
        for (skill in skills) {
            max = Math.max(skill, max)
        }
        return max
    }
}