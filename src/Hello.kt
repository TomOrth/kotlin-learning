/**
 * Created by tom on 6/16/17.
 */

//fun is how u define functions. Neat
fun main(args: Array<String>) {
    println("Hello")

    //Val and var for variables
    //polymorphic type
    //var is normal variable
    //val is read only (final variable)
    val name = "Tom"

    var myAge = "18"

    //Type can be explicitly declared
    var bigInt: Int = Int.MAX_VALUE
    var smallInt: Int = Int.MIN_VALUE

    println("Biggest Int : " + bigInt)
    println("Smallest Int : " + smallInt)

    //var types: Long, Double, Float, Boolean, Short, Byte, Char
    var dblNum1: Double = 1.11111111111111
    var dblNum2: Double = 1.11111111111111

    println("Sum: " + (dblNum1 + dblNum2))

    //check type of a variable and template literals
    var letterGrade: Char = 'A'
    println("letterGrade is a Char: ${letterGrade is Char}")

    //conversion functions
    println("3.14 to Int: " + (3.14.toInt()))
    println("A to Int: " + ('A'.toInt()))
    println("65 to Char: " + (65.toChar()))

    //String stuff
    var longStr = """this is a long
    string"""

    var fName: String = "Tom"
    var lName: String = "Orth"
    var fullName = fName + " " + lName
    //Another form of template literal
    println("Full name: $fullName")

    //equals - True or false
    println(fName.equals(lName))
    //compareTo - 0 if equals, negative if less than function parameter, positive if greater than function parameter
    println("A".compareTo("B"))

    //some common string methods
    println("Index 2: ${fullName.get(2)}")
    println("Index 0 - 2: ${lName.subSequence(0,2)}") //endIndex is non-inclusive
    println("Contains: ${fullName.contains(fName)}")

    //Arrays
    var array = arrayOf(1, 1.23, "Tom")
    println("Array Size: ${array.size}")
    println("Tom in array: ${array.contains("Tom")}")
    var partArray = array.copyOfRange(0,2) //endIndex inclusive
    //these methods are also in strings
    println("First: ${array.first()}")
    println("Index of Tom: ${array.indexOf("Tom")}")
    //different array init style
    //Size then init function (variable is representative of the index
    var sqArray = Array(5, {x -> x * x})
    println(sqArray[3])
    //Array with explicit typing
    var myArray: Array<Int> = arrayOf(1,2,3)

    //ranges
    val oneTo10 = 1..10
    val alpha = "A".."Z"
    println("R in alpha: ${"R" in alpha}")
    val tenTo1 = 10.downTo(1)
    val twoTo20 = 2.rangeTo(20)
    //increases by 3 to the limit
    val rng3 = oneTo10.step(3)

    for (x in rng3) println("rng3: $x")
    for (y in tenTo1.reversed()) println("Reversed: $y")

    var age = 8
    //when logic operator
    when (age) {
        1,2,3,4,5 -> println("Go to school")

        in 10..18 -> println("Young blood")

        in 20..30 -> {
            var grade = age - 5
            println(grade)
        }

        else -> println("Well this is fun")
    }

    var arr3: Array<Int> = arrayOf(3,6,9)
    for (x in arr3.indices) {
        println("$x")
    }

    for ((index, value) in arr3.withIndex()) {
        println("$index, $value")
    }

    //functions
    fun add(v1: Int, v2: Int): Int = v1 + v2
    println("Add 5 + 4: " + add(5,4))

    //default parameters
    fun sub(v1: Int = 1, v2: Int = 2): Int = v1 - v2
    println("Sub 1 -2: " + sub())

    fun pair(x: Int, y: Int): Pair<Int, Int> {
        return Pair(x,y)
    }

    val (x, y) = pair(2,1)
    println("$x, $y")

    println("getSum: " + getSum(1,2,3,4,5,6,7))

    //interesting function declaration
    val multiply = {num1: Int, num2: Int -> num1*num2}

    println("multiply(45, 42): " + multiply(45,42))
    println("factorial of 3: " + fact(3))

    //filter
    val numsList = 1..20
    //to use filter, must use it for the elements
    val evensList = numsList.filter { it % 2 == 0 }
    evensList.forEach { n -> println(n) }

    //reduce
    var rSum: Int = numsList.reduce { x, y -> x+y }
    //fold (has an initial value)
    var fSum: Int = numsList.fold(5) { x, y -> x+y }
    println("$rSum, $fSum")

    println("Evens: ${numsList.any { it % 2 == 0 }}")
    println("Evens: ${numsList.all { it % 2 == 0}}")

    val divisor = 2

    try{
        if (divisor == 0){
            throw IllegalArgumentException("Can't Divide by Zero")
        } else {
            println("5 / $divisor = ${5/divisor}")
        }

    } catch (e: IllegalArgumentException){
        println("${e.message}")
    }

    // ----- LISTS -----
    // There are immutable Lists and mutable MutableLists

    // Create a mutable list
    var list1: MutableList<Int> = mutableListOf(1,2,3,4,5)

    // Create an immutable list
    val list2: List<Int> = listOf(1,2,3)

    // Add an item
    list1.add(6)

    // Get first item
    println("1st : ${list1.first()}")

    // Get last
    println("Last : ${list1.last()}")

    // Get value at index
    println("2nd : ${list1[2]}")

    // Get a list starting from index to another
    var list3 = list1.subList(0, 3)

    // Size of List
    println("Length : ${list1.size}")

    // Clear a Mutable list
    // list3.clear()

    // Remove a value
    list1.remove(1)

    // Remove at index
    list1.removeAt(1)

    // Add value at index
    list1[2] = 10


    list1.forEach { n -> println("Mutable List : $n") }


    // ----- MAPS -----
    // A modifiable collection that holds key value pairs

    // Create a Map
    val map = mutableMapOf<Int, Any?>()

    // Create a Map and add values
    val map2 = mutableMapOf(1 to "Doug", 2 to 25)

    // Add values
    map[1] = "Derek"
    map[2] = 42

    // Get Size
    println("Map Size : ${map.size}")

    // Add a key value
    map.put(3, "Pittsburgh")

    // Remove a key and value
    map.remove(2)

    // Iterate and get keys and values
    for((x, y) in map){
        println("Key : $x Value : $y")
    }

    // ----- CLASSES -----
    // Create an Animal object
    val bowser = Animal("Bowser", 20.0, 13.5)

    // Call method in the class
    bowser.getInfo()

    // ----- INHERITANCE -----
    // Create a class Dog that inherits from
    // the Animal class

    val spot = Dog("Spot", 20.0, 14.5, "Paul Smith")

    spot.getInfo()


    // ----- INTERFACES -----
    // Create a Bird object that implements the
    // Flyable interface

    val tweety = Bird("Tweety", true)

    tweety.fly(10.0)

    // ----- NULL SAFETY -----
    // Null safety is built into Kotlin

    // By default you cannot assign null
    // var nullVal: String = null

    // To allow for a null value use ?
    var nullVal: String? = null

    // A function that may return null uses ?
    // fun myFun(): String?

    // Kotlin provides for the opportunity of a
    // null value if an if statement protects
    // from danger
    fun returnNull(): String? {
        return null
    }

    var nullVal2 = returnNull()

    // This is a smart cast
    if(nullVal2 != null) {
        println(nullVal2.length)
    }

    // We could use the force operator !! to force
    // a null assignment
    var nullVal3 = nullVal2!!.length

    // The Elvis operator assigns a default value
    // if null
    var nullVal4: String = returnNull() ?: "No Name"

}

//variable amount of args(vararg)
fun getSum(vararg nums: Int): Int {
    var sum = 0
    nums.forEach {x -> sum += x}
    return sum
}

fun fact(x: Int): Int {
    //optimize recursive methods
    tailrec fun facTail(y: Int, z: Int): Int {
        if (y == 0) return z
        else return facTail(y-1, y*z)
    }
    return facTail(x, 1)
}

//similar to python lambdas
fun makeMathFunc(num1: Int): (Int) -> Int = {num2 -> num1 * num2}

//pass function as a parameter
fun mathOnList(numsList: Array<Int>, myFunc: (num: Int) -> Int) {
    numsList.forEach { n -> println(myFunc(n)) }
}

// ----- CLASSES -----
// There are no static methods
// Classes are final by default unless marked open
// The fields must also be marked as open

open class Animal (val name: String, var height: Double, var weight: Double){

    // Objects are initialized in init
    init {

        // Regex that matches for a number any place
        // in a string
        val regex = Regex(".*\\d+.*")

        // If these requirements aren't met an
        // IllegalArgumentException is thrown
        require(!name.matches(regex)) {"Animal Name can't Contain Numbers"}

        require(height > 0) {"Height must be greater then 0"}

        require(weight > 0) {"Weight must be greater then 0"}

    }

    // If you want to allow overriding of this method
    // you must use open
    open fun getInfo(): Unit{
        println("$name is $height tall and weighs $weight")
    }
}

// ----- INHERITANCE -----
class Dog(name: String,
          height: Double,
          weight: Double,
          var owner: String) : Animal(name, height, weight){

    // Overriding Animal method
    override fun getInfo(): Unit{
        println("$name is $height tall, weighs $weight and is owned by $owner")
    }

}


// ----- INTERFACES -----
// An interface is a contract that states all fields
// and methods a class must implement

interface Flyable {
    var flies: Boolean

    fun fly(distMiles: Double): Unit
}

// We override flies in the constructor
// To implement the interface we follow the
// constructor parameters with a colon and the
// interface name
class Bird constructor(val name: String, override var flies: Boolean = true) : Flyable{

    // We must also override any methods in the interface
    override fun fly(distMiles: Double): Unit{
        if(flies){
            println("$name flies $distMiles miles")
        }
    }
}