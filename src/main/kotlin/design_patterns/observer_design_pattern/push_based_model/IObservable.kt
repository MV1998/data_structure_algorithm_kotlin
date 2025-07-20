package design_patterns.observer_design_pattern.push_based_model

interface IObservable {
    fun registerObserver(iObserver: IObserver)
    fun unregisterObserver(iObserver: IObserver)
    fun notifyObserver()
}