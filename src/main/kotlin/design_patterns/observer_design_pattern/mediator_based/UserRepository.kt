package design_patterns.observer_design_pattern.mediator_based

class UserRepository(
    val userDatabase: UserDatabase
) : DataProvider {
    override fun getData(userId: String): User {
        return userDatabase.fetchUser(userId)
    }
}