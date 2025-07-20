package design_patterns.observer_design_pattern.mediator_based

class ConcreteMediator: Mediator {

    private val observers = mutableListOf<IObserver>()
    private lateinit var dataProvider: DataProvider

    override fun notifyChange(userId: String) {
        for(observer in observers) {
            observer.onNotified(userId)
        }
    }

    override fun setDataProvider(dataProvider: DataProvider) {
        this.dataProvider = dataProvider
    }

    override fun registerObserver(iObserver: IObserver) {
        iObserver.injectDataProvider(this.dataProvider)
        observers.add(iObserver)
    }

    override fun unregisterObserver(iObserver: IObserver) {
        observers.remove(iObserver)
    }
}