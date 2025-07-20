package design_patterns.observer_design_pattern.mediator_based

class ConcreteObserver(val observerName : String): IObserver {
    private lateinit var dataProvider: DataProvider
    override fun onNotified(userId : String) {
       println("$observerName ${dataProvider.getData(userId)}")
    }

    override fun injectDataProvider(dataProvider: DataProvider) {
        this.dataProvider = dataProvider
    }
}