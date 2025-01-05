package main.kotlin

fun insertionSort(arr: IntArray, n: Int, k: Int) {
    var count = 0  // 저장 횟수를 카운트
    var result = -1  // K번째 저장되는 수를 저장

    for (i in 1 until n) {
        var loc = i - 1
        val newItem = arr[i]

        // A[0..i-1]은 이미 정렬되어 있는 상태
        while (loc >= 0 && newItem < arr[loc]) {
            arr[loc + 1] = arr[loc]  // 실제 저장이 일어나는 부분
            count++
            if (count == k) {  // K번째 저장되는 수를 기록
                result = arr[loc]
            }
            loc--
        }

        if (loc + 1 != i) {  // newItem이 실제로 저장되는 경우
            arr[loc + 1] = newItem
            count++
            if (count == k) {  // K번째 저장되는 수를 기록
                result = newItem
            }
        }
    }
    print(result)
}

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    var numList = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    insertionSort(numList, n, k)
}