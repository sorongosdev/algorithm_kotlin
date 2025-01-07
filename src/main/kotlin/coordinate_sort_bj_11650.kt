package src.main.kotlin

fun main() {
    val coordNum = readln().toInt()
    val coordList = mutableListOf<Pair<Int, Int>>()

    repeat(coordNum) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        coordList.add(Pair(x, y))
    }

    val coordSortedList = coordList.sortedWith(compareBy({ it.first }, { it.second }))

    coordSortedList.forEach { (x, y) ->
        println("$x $y")
    }
}