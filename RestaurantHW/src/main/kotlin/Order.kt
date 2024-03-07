class Order(val dishes:List<Dish>, val number:Int) {
    var status:String = "accepted"
    // Функция возврящает сумму заказа
    fun getTotal(): Int {
        var sum:Int = 0
        for(dish in dishes){
            sum += dish.price
        }
        return sum
    }
    fun show(){
        println("You ordered:")
        var i = 1
        for(dish in dishes){
            print("${i}: ")
            dish.print()
            i++
        }
    }
    fun cook() {
        println("Order №${number} status: ${status}")
        this.status = "cooking in process"
        println("Order №${number} status: ${status}")
        var time: Long = 0
        for (dish in dishes) {
            time += dish.time
        }
        Thread.sleep(time)
        this.status = "cooked"
        println("Order №${number} status: ${status}")
    }
    //Функция для оплаты заказа
    fun pay(){
        println("Your total is ${getTotal()}")
        println("Please enter payment:")
        var input = readln()
        var cash: Int = 0
        var flag: Boolean = true
        do {
            try {
                cash = input.toInt()
                while(cash < getTotal()){
                    println("Not enough money. Please add ${getTotal() - cash} more:")
                    cash += readln().toInt()
                }
                println("Payment accepted!")
                println("Your change is ${cash - getTotal()}")
                status = "payed"
                income+= getTotal()
            } catch (e: Exception) {
                println("Amount is not valid. Please try again.")
                flag = false
            }
        }while(!flag)
    }
}