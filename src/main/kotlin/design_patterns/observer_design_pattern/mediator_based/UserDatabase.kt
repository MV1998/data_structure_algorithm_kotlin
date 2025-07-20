package design_patterns.observer_design_pattern.mediator_based

class UserDatabase {
    private val userDatabase = mutableMapOf<String, User>()

    fun saveUser(userId: String, userName : String) {
        userDatabase.put(userId, User(userId = userId, userName))
    }

    fun fetchUser(userId: String): User {
        return userDatabase.getValue(userId)
    }
}