package design_patterns.observer_design_pattern.mediator_based

class Subject(val mediator: Mediator,
    val db : UserDatabase) {

    fun updateUser(userId : String, userName : String) {
        db.saveUser(userId, userName)
        mediator.notifyChange(userId)
    }
}