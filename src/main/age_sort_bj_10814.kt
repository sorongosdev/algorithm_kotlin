fun main() {
    val peopleNum = readln().toInt()
    val peopleList = mutableListOf<Pair<Int, String>>()

    repeat(peopleNum) {
        val (age, name) = readln().split(" ")
        peopleList.add(Pair(age.toInt(), name))
    }

    // peopleList의 age에 따라 아이템 정렬, 같은 값이면 입력순서 유지(stable sort)
    val peopleSortedList = peopleList.sortedBy { it.first }

    peopleSortedList.forEach { (age, name) ->
        // key와 value를 스페이스로 구분해 출력
        println("$age $name")
    }
}