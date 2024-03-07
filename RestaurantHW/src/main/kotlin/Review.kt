class Review(val dish: Dish) {
    var rate:Int = 0
    var text:String= ""
    init{
        var input: Int = 0
        var flag: Boolean = true
        do {
            println("Please enter the rate from 0 to 5:")
            var n = readln()
            try {
                input = n.toInt()
                if(input >5 || input < 1){
                    println("Rate is not valid. Please try again.")
                    flag = false
                }
                else{
                    flag = true
                }
            } catch (e: Exception) {
                println("Rate is not valid. Please try again.")
                flag = false
            }
        }while(!flag)
        rate = input
        println("Please enter some comment:")
        text = readln()
        println("Thank you!")
        dish.addReview(this)
    }
}