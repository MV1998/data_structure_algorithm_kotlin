package design_patterns.observer_design_pattern.mediator_based

class UserRepository(
    val userDatabase: UserDatabase
) : IDataSource {

    override fun getData(userId: String): User {
        return userDatabase.fetchUser(userId)
    }

    override fun saveUser(userId: String, userName: String) {
        userDatabase.saveUser(userId, userName)
    }
}