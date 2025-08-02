package design_patterns.decorator_design_pattern

import kotlinx.coroutines.runBlocking



interface Notification {
    suspend fun send(to : NotificationData, message : String)
}

fun main() = runBlocking {
    val smsNotification : Notification = PhoneValidator(
        SMSNotification(
            EmailValidator(EmailNotification()))
    )


    smsNotification.send(NotificationData(
        email = "mv501049@.gmail.com",
        phoneNumber = "8602421385"
    ), "Message that i have written")
}