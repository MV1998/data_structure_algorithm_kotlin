package design_patterns.decorator_design_pattern

import kotlinx.coroutines.delay

class SMSNotification (private val decoratedNotification: Notification) :
    NotificationDecorator(decoratedNotification) {
    override suspend fun send(to : NotificationData, message: String) {
        println("SMS Notification is being sent to : ${to.phoneNumber}")
        println("Message : $message")
        delay(2000)
        println("SMS Notification has been send to ${to.phoneNumber}")
        super.send(to, message)
    }
}