object Menu {
    // В меню изначально добавлены несколько блюд для удобства тестирования
    var menu = mutableListOf<Dish>(Dish("Steak", 100, 3, 1000), Dish("Caesar", 50, 6, 3000), Dish("Beer", 10, 10, 100))
    fun show(){
        println("Menu:")
        var i:Int = 1
        for(dish in menu){
            println("${i} ${dish.name} --- ${dish.price}")
            i++
        }
    }
    fun add(dish:Dish){
        menu.add(dish)
    }
    fun remove(number:Int){
        if(!menu.isEmpty()) {
            menu.removeAt(number - 1)
        }
        else{
            println("The menu is empty")
        }
    }
}