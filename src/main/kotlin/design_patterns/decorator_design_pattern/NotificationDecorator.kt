package design_patterns.decorator_design_pattern

abstract class NotificationDecorator(val notification : Notification) : Notification {
    override suspend fun send(to : NotificationData, message: String) {
        notification.send(to, message)
    }
}