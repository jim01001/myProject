fun main() {
    val child1 = Child("Beka", 15) // создание обеъекта класса child с супер классом human
    val child2 = Child("Birzh", 9)
    child1.gettingOld(child1.age) //функция описанная в супер классе доступна "детям"
    println(child1.age)
    child1.getHomeWork("math") // функция описанная в классе тоже может выполняться

 //   val human1 = Human("Kiki",18) мы не сможем создать объект, так как этот класс абстактный

    val woman1 = Woman("Roza", 23)
    //  woman1.getHomeWork //инкапсуляция? функция подкласса не доступна супер классу

    val humans = listOf<Human>(child1, child2, woman1)
    for (human in humans)
        human.getFood("water") // каждому в коллекции дали еду с помощью функции в суперклассе

    child2.getSleep(10) // функция одна, но выполняется по разному
    woman1.getSleep(8)

/*    val man1 = Human("Tony", 32)
    val man2 = Human ("Kate", 18)

    man1.getFood("banana")
    man1.getFood("tomato")
    man2.gettingOld(man2.age)

    println("${man2.name} исполнилось ${man2.age} лет")
    man1.allEaten() */
//    man1.eaten.add("potato") не можем добавить еду потому что коллекия eaten доступна тольк внутри класс и внешне не может быть изменена

}

abstract class Human (  //Наследие: Модификатор open говорит о том, что мы можем взять наследие от этого класса - супер класс . тут тоже пише абстакт, опен уже не нужен
    val name: String,
    var age: Int
) {
    private val eaten: MutableList<String> = mutableListOf <String>() // Инкапсуляция признак private означает что из вне обращаться к этой коллекции не получится, есть еще модификатор проттекстед, это значит что доступен только для наследников

    fun getFood (food: String) {
        eaten.add(food)
        println("$name скушал $food")
    }

/*    fun getSleep(hours:Int) {
        println("$name спал $hours")
    }*/

    abstract fun getSleep(hours:Int) // модификатор abstract позволяет создавать функции без реализации и использовать полиморфизм

    fun gettingOld(age: Int){
        val age1 = age+1
        this.age = age1
    }
}

class Child(name: String, age: Int): Human(name, age) {   //тут мы говорим что мы наследники класса human, в первых скобках мы пуолчаем поля и передаем их
    fun getHomeWork (subject: String) {
        println("$name учит $subject")
    }

    override fun getSleep(hours:Int) { // тут для использования абстрактной функции используем овверайд
        println("Ребенок $name спал $hours")
    }
}

class Woman(name: String, age: Int): Human(name, age){
    fun getBeuty (pocedure: String) {
        println("$name делает $pocedure")
    }

    override fun getSleep(hours:Int) {
        println("Девушка $name спала $hours")
    }
}