package design_patterns.observer_design_pattern.mediator_based

class Subject(val mediator: Mediator, val userRepository: UserRepository) {
    fun updateUser(userId : String, userName : String) {
        userRepository.saveUser(userId, userName)
        mediator.notifyChange(userId)
    }
}