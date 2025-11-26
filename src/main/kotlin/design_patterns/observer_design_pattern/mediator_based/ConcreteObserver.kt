package design_patterns.observer_design_pattern.mediator_based

class ConcreteObserver(val observerName : String): IObserver {
    private lateinit var iDataSource: IDataSource
    override fun onNotified(userId : String) {
       println("$observerName ${iDataSource.getData(userId)}")
    }

    override fun injectDataProvider(iDataSource: IDataSource) {
        this.iDataSource = iDataSource
    }
}