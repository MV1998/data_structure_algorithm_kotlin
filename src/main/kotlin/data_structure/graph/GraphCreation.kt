package data_structure.graph

import java.io.File
import java.io.FileReader

fun main() {

    val fileInput = FileReader(File("src/main/kotlin/data_structure/graph/graph.txt")).readLines()
    val graph = createAdjacencyListGraph(fileInput)
    for (index in graph.indices) {
        println("$index --> ${graph[index]}")
    }
    println()
    bfsOnAdjacencyListGraph(graph, 0)

//    val matrixGraph = createAdjacencyMatrixGraph()
//    for (index in matrixGraph.indices) {
//        for (neighbors in matrixGraph[index]) {
//            print("$neighbors ")
//        }
//        println()
//    }
}


fun bfsOnAdjacencyListGraph(graph : Array<MutableList<Int>>, entry : Int) {
    val visited = BooleanArray(graph.size) { false }
    val queue = ArrayDeque<Int>()
    queue.addLast(entry)
    while (queue.isNotEmpty()) {
        val vertex = queue.removeFirst()
        if (!visited[vertex]) {
            print("$vertex ")
            visited[vertex] = true
        }
        for (neighbors in graph[vertex]) {
            if (!visited[neighbors]) {
                queue.addLast(neighbors)
            }
        }
    }
}

fun createAdjacencyMatrixGraph() : Array<Array<Int>> {
    val vertices = readln().toInt()
    val edges = readln().toInt()
    val graph = Array(vertices) {Array<Int>(vertices) {0} }
    repeat(edges) {
        val v1 = readln().toInt()
        val v2 = readln().toInt()
        graph[v1][v2] = 1
        graph[v2][v1] = 1
    }

    return graph
}

fun createAdjacencyListGraph(fileInput : List<String>) : Array<MutableList<Int>> {
    // array or list
    val vertices = fileInput[0].toInt() // total vertices
    val edges = fileInput[1].toInt() // total edges

    val graph = Array(vertices) {mutableListOf<Int>()}

    var eachVertex = 2
    repeat(edges) {
        val v1 = fileInput[eachVertex].toInt()
        val v2 = fileInput[eachVertex+1].toInt()
        graph[v1].add(v2)
        graph[v2].add(v1)
        eachVertex += 2
    }
    return graph
}
