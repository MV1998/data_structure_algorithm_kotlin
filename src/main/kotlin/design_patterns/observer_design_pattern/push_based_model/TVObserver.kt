package design_patterns.observer_design_pattern.push_based_model

class TVObserver : IObserver{
    override fun onNotify(data: String) {
        println("TVObserver : $data")
    }
}