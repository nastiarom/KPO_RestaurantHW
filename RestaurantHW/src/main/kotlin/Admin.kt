class Admin:User {

    fun addDish(menu:Menu){
        println("Please enter the dish name:")
        var name:String = readln()
        var price: Int = 0
        var amount: Int = 0
        var time: Int = 0
        do {
            var flag:Boolean = true
            println("Please enter price:")
            var p: String = readln()
            println("Please enter the amount of dish:")
            var a: String = readln()
            println("Please enter the prepairing time:")
            var t: String = readln()
            try {
                price = p.toInt()
                amount = a.toInt()
                time = t.toInt()
            } catch (e: Exception) {
                println("Input is not valid. Please try again.")
                flag = false
            }
        } while(!flag)
        var dish:Dish = Dish(name, price, amount, time)
        menu.add(dish)
        println("${dish.name} was added to the menu.")
    }
    fun removeDish(menu:Menu){
        if(!menu.menu.isEmpty()) {
            showMenu(menu)
            var number: Int = 0
            do {
                var flag: Boolean = true
                println("Enter the dish number:")
                var n: String = readln()
                try {
                    number = n.toInt()
                } catch (e: Exception) {
                    println("Number is not valid. Please try again.")
                    flag = false
                }
            } while (!flag)
            if(number <= menu.menu.size){
                menu.remove(number)
                println("Dish removed!")
            }
            else {
                println("No such dish")
            }
        }
        else{
            println("The menu is empty")
        }
    }
    fun changePasword(pass:String){
        println("Please enter the new password:")
        var password:String = readln()
        if(passwordCodes.contains(password.hashCode())){
            println("Еhe new password is the same as the old one")
        }
        else{
            passwordCodes.remove(pass.hashCode())
            passwordCodes.add(password.hashCode())
            println("Password changed!")
        }
    }
    fun editDish(menu: Menu){
        if(!menu.menu.isEmpty()) {
            showMenu(menu)
            var number: Int = 0
            do {
                var flag: Boolean = true
                println("Enter the dish number:")
                var n: String = readln()
                try {
                    number = n.toInt()
                } catch (e: Exception) {
                    println("Number is not valid. Please try again.")
                    flag = false
                }
            } while (!flag)
            if (number <= menu.menu.size) {
                println("Please enter new dish information:")
                var price: Int = 0
                var amount: Int = 0
                var time: Int = 0
                do {
                    var flag: Boolean = true
                    println("Enter price:")
                    var p: String = readln()
                    println("Enter the amount of dish:")
                    var a: String = readln()
                    println("Enter the prepairing time:")
                    var t: String = readln()
                    try {
                        price = p.toInt()
                        amount = a.toInt()
                        time = t.toInt()
                    } catch (e: Exception) {
                        println("Input is not valid. Please try again.")
                        flag = false
                    }
                } while (!flag)
                menu.menu.elementAt(number - 1).price = price
                menu.menu.elementAt(number - 1).amount = amount
                menu.menu.elementAt(number - 1).time = time
            } else {
                println("No such dish")
            }
        }
    }
}