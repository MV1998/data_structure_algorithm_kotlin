package design_patterns.observer_design_pattern.mediator_based

interface IObserver {
    fun onNotified(userId : String)
    fun injectDataProvider(dataProvider: DataProvider)
}