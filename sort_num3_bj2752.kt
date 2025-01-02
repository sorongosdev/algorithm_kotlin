fun main(){
    val input = readLine()
    val list = input!!.split(" ").map { it.toInt() }

    val sortedList = list.sorted()
    sortedList.forEach { print("$it ") }
}