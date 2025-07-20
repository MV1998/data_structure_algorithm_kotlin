package design_patterns.observer_design_pattern.pull_based_model


interface IObservable {
    fun registerObserver(iObserver: IObserver)
    fun unregisterObserver(iObserver: IObserver)
    fun notifyObserver()
}