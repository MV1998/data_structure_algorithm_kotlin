package design_patterns.observer_design_pattern.mediator_based

interface IDataSource {
    fun getData(userId : String) : User

    fun saveUser(userId: String, userName : String)
}