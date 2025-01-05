fun main() {
    val numList = mutableListOf<Int>()
    repeat(5){
        numList.add(readLine()!!.toInt())
    }

    val sortedNumList = numList.sorted()

    var sum = 0

    sortedNumList.forEach{
        sum += it
    }

    val average = sum / 5
    val median = sortedNumList[2]

    println(average)
    println(median)
}