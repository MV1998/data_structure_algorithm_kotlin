package design_patterns.observer_design_pattern.mediator_based

interface Mediator {
    fun notifyChange(userId : String)
    fun setDataProvider(dataProvider: DataProvider)
    fun registerObserver(iObserver: IObserver)
    fun unregisterObserver(iObserver: IObserver)
}