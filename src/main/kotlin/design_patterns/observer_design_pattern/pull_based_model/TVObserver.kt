package design_patterns.observer_design_pattern.pull_based_model

class TVObserver(val weatherStationObservable: WeatherStationObservable) : IObserver{
    override fun onNotify() {
        println("TVObserver : ${weatherStationObservable.getData()}")
    }
}