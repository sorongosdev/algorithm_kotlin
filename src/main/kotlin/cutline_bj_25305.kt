package main.kotlin

fun main() {
    val (N, k) = readLine()!!.split(" ").map { it.toInt() }

    val scoreList = readLine()!!.split(" ").map { it.toInt() }

    val sortedScoreList = scoreList.sortedDescending()

    println(sortedScoreList[k-1])
}