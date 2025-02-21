fun main(){
    val word = readLine()!!.map{it.toLowerCase()}
    val howMany = mutableListOf<Pair<Char,Int>>()

    for (i in 0 until word.size){
        val letter = howMany.map{it.first}
        if (word[i] in letter){ // 안에 있다면
            val index = letter.indexOf(word[i])
            howMany[index] = Pair(howMany[index].first,howMany[index].second + 1)
        } else{ // 안에 없으면
            howMany.add(Pair(word[i], 1))
        }
    }

    val maxVal = howMany.map{it.second}.maxOrNull()

    var cnt = 0
    for (i in 0 until howMany.size){
        if(howMany[i].second == maxVal){
            cnt ++
        }
    }

    val maxIndex = howMany.map{it.second}.indexOf(maxVal)

    if(cnt == 1) println(howMany.map{it.first}[maxIndex].toUpperCase())
    else println('?')
}