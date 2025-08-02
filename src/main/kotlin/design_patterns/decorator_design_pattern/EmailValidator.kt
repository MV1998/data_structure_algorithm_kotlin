package design_patterns.decorator_design_pattern

class EmailValidator(private val decorator: Notification) : Notification {
    override suspend fun send(to : NotificationData, message: String) {
        require(EMAIL_REGEX.matches(to.email)) {
            "Invalid email format: ${to.email}"
        }
        decorator.send(to, message)
    }
    companion object {
        private val EMAIL_REGEX = Regex(
            "^[a-zA-Z0-9](?:[\\w.%+-])*@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$"
        )
    }
}