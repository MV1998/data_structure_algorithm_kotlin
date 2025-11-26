package design_patterns.chain_of_responsibility

abstract class Logger(val level: Int, open val logProcessor: Logger? = null) {
    companion object {
        const val DEBUG = 1
        const val INFO = 2
        const val ERROR = 3
        const val FATAL = 4
    }

    fun log(level : Int, message: String) {
        if (this.level == level) {
            write(message)
            return
        }
        logProcessor?.log(level, message)
    }

    abstract fun write(message : String)
}

class DebugLogger(override val logProcessor: Logger?): Logger(Logger.DEBUG, logProcessor) {
    override fun write(message: String) {
        println("Debug : $level : $message")
    }
}

class InfoLogger(override val logProcessor: Logger?): Logger(Logger.INFO, logProcessor) {
    override fun write(message: String) {
        println("Info : $level : $message")
    }
}

class ErrorLogger( override val logProcessor: Logger?): Logger(Logger.ERROR, logProcessor) {
    override fun write(message: String) {
        println("Error : $level : $message")
    }
}

class FatalLogger(override val logProcessor: Logger?): Logger(Logger.FATAL, logProcessor) {
    override fun write(message: String) {
        println("Fatal : $level : $message")
    }
}

fun buildLogger() : Logger {
    val fatalLogger = FatalLogger(null)
    val errorLogger = ErrorLogger(fatalLogger)
    val infoLogger = InfoLogger(errorLogger)
    val debugLogger = DebugLogger(infoLogger)
    return debugLogger
}


fun main() {
    val logger = buildLogger()
    logger.log(Logger.FATAL, "Hello World")
}