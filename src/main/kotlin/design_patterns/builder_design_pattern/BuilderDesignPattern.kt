package design_patterns.builder_design_pattern


fun main() {
    val pizza = Pizza.builder()
        .setName("Pizza")
        .setTopping("Mohit")
        .build()
    println(pizza)
}


data class Pizza(val name : String,
                 val topping: String?) {

    companion object {
        fun builder() = Builder()
    }

   class Builder {
        private var name : String = "Default Name"
        private var topping : String? = null

        fun setName(name : String) = apply {
            this.name = name
        }

        fun setTopping(topping : String) = apply {
            this.topping = topping
        }

        fun build() = Pizza(name, topping)
    }
}