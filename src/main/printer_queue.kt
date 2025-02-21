fun main(){
    val tc = readLine()!!.toInt()
    val answer = IntArray(tc)

    for (i in 0 until tc){
        val (n,m) = readLine()!!.split(" ").map{it.toInt()} // n개 문서, 큐에서 m번째로 놓임.

        // tc별로 입력 받음
        val docs = readLine()!!.split(" ").map{it.toInt()}
        val docDeq = ArrayDeque<Pair<Int,Int>>() // 원래 인덱스 정보도 담고있는 배열

        for (j in 0 until n){
            docDeq.add(Pair(docs[j],j))
        }

        var cnt = 0

        while(docs.isNotEmpty()){

            val first = docDeq[0]
            val maxVal = docDeq.map{it.first}.toIntArray().maxOrNull()

            if (first.first != maxVal){ // 우선순위가 최대값이 아니면 뒤에 first를 추가함.
                docDeq.addLast(first)
                docDeq.removeFirst()
            }
            else { // 우선순위가 최대값이라면
                cnt ++ // 문서 출력 카운트

                if(first.second == m){ // 우선순위가 최대이면서 물어본 값이면
                    answer[i] = cnt
                    break
                }

                docDeq.removeFirst()
            }

        }
    }

    answer.forEach{
        println(it)
    }
}