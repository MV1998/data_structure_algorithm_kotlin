package data_structure.maths


internal class Solution {
    fun digitsInFactorial(N: Int): Int {
        // code here
        return 0
    }
}


fun main() {
//    println(isPalindrome(78987))
//    println(trailingZerosInFact(2482))
//    println(gcd(4,6))
//    println(euclidean(4,6))
//    println(euclideanGCD(12,15))
//    println(lcm(4,6))
//
//    println(isPrime(121))
//    println(isPrimeSqrt(65))
//
//    println(isPrimeEfficient(1031))
//
//    println(printPrimeFactors(450))
//    printAllDivisors(15)
//
//    sieve(25)
//
//    println(quadraticRoots(752, 904, 164))

    println(digitsInFactorial(5))
}

fun digitsInFactorial(N: Int): Int {
    var fact = findFact(N)
    println(fact)
    var totalDigits = 0
    while (fact > 0) {
        fact /= 10
        totalDigits++
    }
    return totalDigits
}

fun findFact(n : Int) : Int {
    var res = 1
    for (i in 2..n) {
        res = res * i
    }
    return res
}

fun quadraticRoots(a: Int, b: Int, c: Int) : List<Int> {
    if (a == 0) return listOf<Int>(-1,-1)

    val D : Double = (b*b - 4 * a * c).toDouble()

    if (D < 0) return listOf<Int>(-1,-1)

    val firstRoot = (-b + Math.sqrt(D)) / 2 * a
    val secondRoot = (-b - Math.sqrt(D)) / 2 * a

    return if (firstRoot > secondRoot) listOf<Int>(firstRoot.toInt(), secondRoot.toInt())
    else listOf<Int>(secondRoot.toInt(), firstRoot.toInt())
}

fun power(X : Int, N : Int) : Int {
    var n = N
    var x = X
    var res = 1
    while (n > 0) {
        if (n % 2 != 0) {
            res *= x
        }
        x *= x
        n /= 2
    }
    return res
}


fun sieve(n : Int) {
    val arr = Array<Boolean>(n+1) {true}
    var i = 2
    while (i * i<= n) {
        if (arr[i]) {
            var j = i * i
            while(j <= n) {
                arr[j] = false
                j += i
            }
        }

        i++
    }

    for (i in 2..n) {
        if (arr[i]) {
            println(i)
        }
    }
}


fun printAllDivisors(n : Int) {
    var i = 1
    while (i * i < n) {
        if (n % i == 0) {
            println(i)
        }
        i++
    }
    while(i >= 1) {
        if (n % i == 0) {
            println(n/i)
        }
        i--
    }
}


fun printPrimeFactors(N : Int) {
    var n = N
    if (n <= 1) return
    while(n % 2 == 0) {
        println(2)
        n /= 2
    }
    while (n % 3 == 0) {
        println(3)
        n /= 3
    }
    var i = 5
    while (i * i <= n) {
        while(n % i == 0) {
            println(i)

            n /= i
        }

        while(n % (i + 2) == 0) {
            println(i+2)

            n /= (i + 2)
        }

        i += 6
    }
    if (n > 3)
        println(n)
}


fun isPrime(n : Int) : Boolean {
    if (n == 1) return false
    var i = 2
    while (i < n) {
        if (n % i == 0) return false

        i++
    }
    return true
}

fun isPrimeSqrt(n : Int) : Boolean {
    if (n == 1) return false
    var i = 2
    while (i * i < n) {
        if (n % i == 0) return false

        i++
    }
    return true
}

fun isPrimeEfficient(n : Int) : Boolean {
    if (n == 1) return false
    if (n == 2 || n == 3) return true
    if (n % 2 == 0 || n % 3 == 0) return false
    var i = 5
    while (i * i <= n) {
        if (n % i == 0 || n % (i+2) == 0) {return false}
        i += 6
    }
    return true
}


fun lcm(a: Int, b : Int): Int {
    var res = Math.max(a,b)
    while (true) {
        if (res % a == 0 && res % b == 0) {
            return res
        }
        res++
    }
}

fun lcmEuclidean(a: Int, b : Int): Int {
    return (a * b) / euclideanGCD(a,b)
}

fun euclideanGCD(a : Int, b : Int) : Int {
    if (b == 0) return a
    return euclideanGCD(b, a % b)
}

fun euclidean(i : Int, j : Int) : Int {
    var a = i
    var b = j
    while (a != b) {
        if (a > b) {
            a -= b
        }else {
            b -= a
        }
    }
    return a
}

fun gcd(a: Int, b : Int) : Int {
    var res = Math.min(a,b)
    while (res > 0) {
        if (a % res == 0 && b % res == 0) {
            break
        }
        res--
    }
    return res
}

fun trailingZerosInFact(n : Int) : Int {
    var res = 0
    var i = 5
    while (i <= n) {
        res = res + n / i
        i = i * 5
    }
    return res
}

fun isPalindrome(n: Int): Boolean {
    var temp = n
    var reverseNumber = 0
    while (temp > 0) {
        reverseNumber = (reverseNumber * 10 + (temp % 10))
        temp = temp / 10
    }
    println(reverseNumber)
    return n == reverseNumber
}