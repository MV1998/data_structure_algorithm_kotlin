package design_patterns.observer_design_pattern


import design_patterns.observer_design_pattern.mediator_based.ConcreteMediator
import design_patterns.observer_design_pattern.mediator_based.ConcreteObserver
import design_patterns.observer_design_pattern.mediator_based.Subject
import design_patterns.observer_design_pattern.mediator_based.UserDatabase
import design_patterns.observer_design_pattern.mediator_based.UserRepository
import design_patterns.observer_design_pattern.pull_based_model.MobileObserver
import design_patterns.observer_design_pattern.pull_based_model.TVObserver
import design_patterns.observer_design_pattern.pull_based_model.WeatherStationObservable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
//    val weatherStationObservable = WeatherStationObservable()
//    weatherStationObservable.registerObserver(TVObserver(weatherStationObservable))
//    weatherStationObservable.registerObserver(MobileObserver(weatherStationObservable))
//    weatherStationObservable.changeTemperature("23")
//
//    delay(1000)
//    weatherStationObservable.changeTemperature("24")


    val userDatabase = UserDatabase()
    val userRepository = UserRepository(userDatabase)

    val concreteMediator = ConcreteMediator()
    concreteMediator.setDataProvider(userRepository)

    val observer1 = ConcreteObserver("Observer 1")
    val observer2 = ConcreteObserver("Observer 2")

    concreteMediator.registerObserver(observer1)
    concreteMediator.registerObserver(observer2)


    val subject = Subject(concreteMediator, userRepository)
    subject.updateUser("user_1", "Mohit Varma")
    delay(1000)
    subject.updateUser("user_2", "Vaibhav Patil")
    delay(1000)
    subject.updateUser("user_1", "Mohit Kishor Varma")

}