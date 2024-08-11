package flows

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    println("Zip Operator")
    downloadSongOne()
        .zip(downloadSongTwo()) { firstResult, secondResult ->
            return@zip  "$firstResult and $secondResult"
        }
        .flowOn(Dispatchers.IO)
        .collect {
        println(it)
    }
}

fun downloadSongOne(): Flow<String> {
    return flow {
        delay(1000)
        emit("Song1Downloaded 1")
    }
}

fun downloadSongTwo(): Flow<String> {
    return flow {
        delay(5000)
        emit("Song1Downloaded 2")
    }
}
