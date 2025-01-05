fun main(){
    val players = readLine()!!.toInt()
    var maxScore = 0

    repeat(players){
        val performanceList = readLine()!!.split(" ").map { it.toInt() }
        val totalScore = getTotalScore(performanceList)
        if(totalScore > maxScore){
            maxScore = totalScore
        }
    }
    print(maxScore)
}

fun getTotalScore(performanceList: List<Int>): Int{
    val runDescendingList = performanceList.subList(0,2).sortedDescending()
    val trickDescendingList = performanceList.subList(2,7).sortedDescending()
    return runDescendingList[0] + trickDescendingList[0] + trickDescendingList[1]
}