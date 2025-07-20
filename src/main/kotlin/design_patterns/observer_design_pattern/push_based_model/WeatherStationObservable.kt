package design_patterns.observer_design_pattern.push_based_model

class WeatherStationObservable : IObservable {

    private var data : String = ""
    private val weatherStationObservable = mutableListOf<IObserver>()

    override fun registerObserver(iObserver: IObserver) {
        weatherStationObservable.add(iObserver)
    }

    override fun unregisterObserver(iObserver: IObserver) {
        weatherStationObservable.remove(iObserver)
    }

    override fun notifyObserver() {
        for(iObserver in weatherStationObservable) {
            iObserver.onNotify(data)
        }
    }

    fun changeTemperature(data : String) {
        this.data = data
        notifyObserver()
    }
}