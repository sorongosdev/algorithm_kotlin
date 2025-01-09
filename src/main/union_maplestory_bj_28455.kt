fun main() {
    val N = readLine()!!.toInt()
    val levelList = mutableListOf<Int>()

    val xpList = listOf(60, 100, 140, 200, 250)

    repeat(N) {
        levelList.add(readLine()!!.toInt())
    }

    val sortedLevelList = levelList.sortedDescending().take(minOf(N, 42))

    var levelSum = sortedLevelList.sum()
    var xpSum = 0

    // get xpSum
    xpList.forEach { xp ->
        sortedLevelList.forEach{ L ->
            if(L >= xp){
                xpSum += 1
            }
        }
    }


    print("$levelSum $xpSum")
}