class Dish(val name:String, var price:Int, var amount:Int, var time:Int ) {
    var reviews = mutableListOf<Review>()
    fun print(){
        println("${this.name} --- ${this.price}")
    }
    fun addReview(review: Review){
        reviews.add(review)
    }
}