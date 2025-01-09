fun main() {
    val n = readln().toInt()
    val numList = mutableListOf<String>()

    repeat(n) {
        numList.add(readln())
    }

    val sortedNumList = numList.sortedWith(
        compareBy<String> { it.length }
            .thenBy { str ->
                str.filter { it.isDigit() }
                    //여기서 it은 char
                    // char의 toInt는 아스키코드를 반환하므로 이중변환 해줘야함
                    .sumOf { it.toString().toInt() }
            }
            .thenBy {
                it
            }
    )

    sortedNumList.forEach { println(it) }
}