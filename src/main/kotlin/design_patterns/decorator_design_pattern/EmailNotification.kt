package design_patterns.decorator_design_pattern

import kotlinx.coroutines.delay

class EmailNotification : Notification {
    override suspend fun send(to : NotificationData, message: String) {
        println("Email is being sent to : ${to.email}")
        println("Message : $message")
        delay(2000)
        println("Email has been send to ${to.email}")
    }
}