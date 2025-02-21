fun main(){
    val n = readLine()!!.toInt()
    var answer = 0

    // 그룹단어 조건
    // 떨어져서 나타나면 그룹단어가 아님.
    // 최초로 등장한 문자가 붙어서 나타나야만 그룹단어.

    for (i in 0 until n){
        val word = readLine()!!.map{it}

        val checked = mutableListOf<Char>()
        var flag = word[0]
        checked.add(flag)

        var index = 1
        var isGroupWord = true

//        println()
//        println("checked inited? $checked")

        while(index != word.size){ // 인덱스 다 돌 때까지 순회
            if(word.size == 1){
                break
            }
            if(word[index] != flag){ // 새로운 문자 발견했는데
                if(word[index] !in checked) { // checked 안에 없음
                    checked.add(word[index])
//                    println("checked added $checked")
                    flag = word[index]
                } else{ // checked 안에 있음
//                    println("group word false! when index $index and the word ${word[index]}")

                    isGroupWord = false
                    break
                }
            }
            index ++
        }

        if(isGroupWord) answer++
    }

    println(answer)
}