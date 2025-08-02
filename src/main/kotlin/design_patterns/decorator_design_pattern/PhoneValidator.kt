package design_patterns.decorator_design_pattern

class PhoneValidator(private val decorator: Notification) : Notification {
    override suspend fun send(to : NotificationData, message: String) {
        require(INDIA_MOBILE_REGEX.matches(to.phoneNumber)) {
            "Invalid phone number: ${to.phoneNumber}"
        }
        decorator.send(to, message)
    }
    companion object {
        private val INDIA_MOBILE_REGEX = Regex("^[6-9]\\d{9}\$")
    }
}