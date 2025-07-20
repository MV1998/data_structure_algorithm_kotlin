package design_patterns.observer_design_pattern.push_based_model

interface IObserver {
    fun onNotify(data : String)
}