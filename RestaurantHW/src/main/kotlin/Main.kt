// Для удобства тестирования в списке хешей хранится один пароль администратора
var passwordCodes = mutableListOf<Int>("qwerty".hashCode())
fun authentify(password:String):Boolean{
    if(passwordCodes.contains(password.hashCode())){
        return true;
    }
    return false;
}

var users = mutableListOf<User>()
var income = 0
var menu:Menu = Menu
val caretaker = Caretaker()

fun main() {
    var originator = Originator(State(menu, income,users))
    caretaker.saveState(originator)
    println("Welcome to the restaurant system!")
    var orderNumber:Int = 1
    var input:String = ""
    while(input != "Exit" && input != "exit") {
        println("Please enter your status (Admin/Visitor):")
        input = readln()
        if (input== "Admin" || input == "admin") {
            println("Please enter your password:")
            val pass:String = readln()
            if(authentify(pass)){
                println("Welcome, admin!")
                val admin = Admin()
                users.add(admin)
                println("If you want to add some dish to the menu type add;")
                println("If you want to delete a dish from the menu type remove;")
                println("If you want to change your password type change;")
                println("If you want to edit some dish information type edit:")
                println("If you want to see the menu type menu:")
                input = readln()
                if(input == "add" || input == "Add"){
                    admin.addDish(menu)
                }
                else if(input == "remove" || input == "Remove"){
                    admin.removeDish(menu)
                }
                else if(input == "change" || input == "Change"){
                    admin.changePasword(pass)
                }
                else if(input == "edit" || input == "Edit"){
                    admin.editDish(menu)
                }
                else if(input == "menu" || input == "Menu"){
                    menu.show()
                }
                else{
                    println("No such option.")
                }
                originator = Originator(State(menu, income,users))
                caretaker.saveState(originator)
                users.remove(admin)
                originator = Originator(State(menu, income,users))
                caretaker.saveState(originator)
            }
            else{
                println("Access denied.")
                println("Please enter your status again or type Exit:")
                input = readln()
            }
        } else if (input== "Visitor" || input == "visitor") {
            println("Hello and welcome!")
            val visitor = Visitor()
            users.add(visitor)
            println("Do you want to see the menu? (Yes/No):")
            input = readln()
            if(input == "yes" || input == "Yes"){
                visitor.showMenu(menu)
            }
            else if(input == "No" || input == "no"){
                println("Okay!")
            }
            else{
                println("No such option.")
            }
            println("Do you want to place order? (Yes/No):")
            input = readln()
            if(input == "yes" || input == "Yes"){
                visitor.placeOrder(menu, orderNumber)
                orderNumber+=1
                println("Do you want to add the review? (Yes/No):")
                input = readln()
                if(input == "yes" || input == "Yes"){
                    visitor.addReview(menu)
                }else{
                    println("Okay!")
                    println("Have a nice day, goodbye!")
                }
            }
            else if(input == "No" || input == "no"){
                println("Okay!")
            }
            else{
                println("No such option.")
            }
            originator = Originator(State(menu, income,users))
            caretaker.saveState(originator)
            users.remove(visitor)
            originator = Originator(State(menu, income,users))
            caretaker.saveState(originator)
        }
        else if(input == "exit" || input == "Exit"){
            break
        }else {
            println("No such status. Please try again or type Exit to exit the app.")
        }
    }
    originator = Originator(State(menu, income,users))
    caretaker.saveState(originator)
    print("Goodbye!")
}