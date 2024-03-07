class Visitor:User {
    fun placeOrder(menu:Menu, orderNumber:Int){
        var dishes:MutableList<Dish> = mutableListOf()
        var n: String = ""
        while(n != "Done" && n != "done" ) {
            println("Please enter the dish number or type Done when finis ordering:")
            n = readln()
            if(n != "Done" && n != "done") {
                var number: Int = 0
                var flag: Boolean = true
                do {
                    try {
                        number = n.toInt()
                    } catch (e: Exception) {
                        println("Number is not valid. Please try again.")
                        flag = false
                    }
                }while(!flag)
                if(number <= menu.menu.size) {
                    if(menu.menu.elementAt(number - 1).amount > 0){
                        dishes.add(menu.menu.elementAt(number - 1))
                        menu.menu.elementAt(number - 1).amount -=1
                        print("Dish added!")
                    }
                    else{
                        println("Sorry, no more dishes left :(")
                    }
                }
                else{
                    println("No such dish")
                }
            }
        }
        if(dishes.isEmpty()){
            println("You didn't order anything :(")
        }
        else {
            val thread = Thread {
                var order: Order = Order(dishes, orderNumber)
                order.show()
                println("Your total is ---- ${order.getTotal()}")
                order.cook()
                order.pay()
                dishes.clear()
            }
            // Приоритет вычисляется как 11 - номер заказа
            // Таким образом, чем раньше был сделан заказ, тем выше у него будет приоритет
            var priority = 11 - orderNumber
            if(priority > 1) {
                thread.priority = priority
            }else{
                thread.priority = Thread.MIN_PRIORITY
            }
            thread.run()
        }
    }
    fun addReview(menu:Menu){
        showMenu(menu)
        println("Please enter the number of dish that you want to rate:")
        var number: Int = 0
        var flag: Boolean = true
        do {
            var n = readln()
            try {
                number = n.toInt()
            } catch (e: Exception) {
                println("Number is not valid. Please try again.")
                flag = false
            }
        }while(!flag)
        if(number <= menu.menu.size) {
            var review = Review(menu.menu.elementAt(number-1))
        }
        else{
            println("No such dish")
        }
    }
}