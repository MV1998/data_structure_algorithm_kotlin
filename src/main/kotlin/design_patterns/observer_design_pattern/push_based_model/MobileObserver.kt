package design_patterns.observer_design_pattern.push_based_model

class MobileObserver : IObserver{
    override fun onNotify(data: String) {
        println("Mobile Observer : $data")
    }
}