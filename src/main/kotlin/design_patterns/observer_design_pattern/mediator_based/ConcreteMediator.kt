package design_patterns.observer_design_pattern.mediator_based

class ConcreteMediator: Mediator {

    private val observers = mutableListOf<IObserver>()
    private lateinit var iDataSource: IDataSource

    override fun notifyChange(userId: String) {
        for(observer in observers) {
            observer.onNotified(userId)
        }
    }

    override fun setDataProvider(iDataSource: IDataSource) {
        this.iDataSource = iDataSource
    }

    override fun registerObserver(iObserver: IObserver) {
        iObserver.injectDataProvider(this.iDataSource)
        observers.add(iObserver)
    }

    override fun unregisterObserver(iObserver: IObserver) {
        observers.remove(iObserver)
    }
}