package design_patterns.observer_design_pattern.pull_based_model

class MobileObserver(val weatherStationObservable: WeatherStationObservable) : IObserver{
    override fun onNotify() {
        println("Mobile Observer : ${weatherStationObservable.getData()}")
    }
}