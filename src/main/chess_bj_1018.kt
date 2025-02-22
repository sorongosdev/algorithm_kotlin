fun main(){
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    val chessBoard = Array(n){CharArray(m)}

    for (i in 0 until n){
        chessBoard[i] = readLine()!!.map{it}.toCharArray()
    }

    val maxX = n - 8 // x 시작점의 최대값
    val maxY = m - 8 // y 시작점의 최대값

    var minSquare = 64

    for (i in 0..maxX){
        for (j in 0..maxY){
            minSquare = minOf(minSquare, count(i,j,chessBoard))
        }
    }

    println(minSquare)

}

fun count(startX:Int, startY:Int, chess:Array<CharArray>): Int{
    var startW = 0
    var startB = 0

    for (i in 0 until 8){
        for (j in 0 until 8){
            val x = startX + i
            val y = startY + j

            if ((x+y)%2 == 0){ // 행과 열의 합이 짝수일 때
                if(chess[x][y] != 'W') startW ++
                else if(chess[x][y] != 'B') startB ++
            } else { // 홀수일 때
                if(chess[x][y] != 'B') startW ++
                else if(chess[x][y] != 'W') startB ++
            }
        }
    }

    return minOf(startW,startB)
}