fun main(){
    val numLed = arrayOf(
        intArrayOf(1,1,1,0,1,1,1), //0 // 위에서 내려오는 방향
        intArrayOf(0,0,1,0,0,1,0), //1
        intArrayOf(1,0,1,1,1,0,1), //2
        intArrayOf(1,0,1,1,0,1,1),
        intArrayOf(0,1,1,1,0,1,0),
        intArrayOf(1,1,0,1,0,1,1),
        intArrayOf(1,1,0,1,1,1,1),
        intArrayOf(1,1,1,0,0,1,0),
        intArrayOf(1,1,1,1,1,1,1),
        intArrayOf(1,1,1,1,0,1,1)
    )

    val t = readln().toInt()
    var result = IntArray(t) // 결과

    for (i in 0 until t){
        var count = 0

        val (a,b) = readln().split(" ").map{it.toInt()}

        var a_board = Array(5){IntArray(7){0}} // 각행은 각 자리수
        var b_board = Array(5){IntArray(7){0}}

        val new_a = a.toString() //1
        val new_b = b.toString() //2

        // init
        for (j in 0 until 5){
            if (new_a.length > j) {
                a_board[j] = numLed[new_a[new_a.length - 1 - j].toString().toInt()] //
            }
            if (new_b.length > j) {
                b_board[j] = numLed[new_b[new_b.length - 1 - j].toString().toInt()] //
            }

            for (k in 0 until 7){
                if(a_board[j][k] != b_board[j][k]) count ++
            }

        }

        result[i] = count
    }

    result.map{
        println(it)
    }
}