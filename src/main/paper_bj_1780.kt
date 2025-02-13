fun main(){
    val n = readLine()!!.toInt()

    val paper = Array(n){IntArray(n)}

    val count = intArrayOf(0,0,0)

    for (i in 0 until n){
        paper[i] = readLine()!!.split(" ").map{it.toInt()}.toIntArray()
    }

    divide(n, paper, 0, 0, count)

    count.forEach{
        println(it)
    }
}

fun divide(size: Int, paper: Array<IntArray>, row: Int, col: Int, count: IntArray){ // n은 3의 배수

    if (checkSame(size,paper,row,col,count)){
        val number = paper[row][col] // 맨 처음 요소
        count[number+1] ++
        return
    }

    val newSize = size / 3

    for (i in 0 until 3){
        for (j in 0 until 3){
            divide(
                newSize,
                paper,
                row + i * newSize,
                col + j * newSize,
                count
            )
        }
    }
}

fun checkSame(size: Int, paper: Array<IntArray>, row: Int, col: Int, count: IntArray): Boolean{
    val first = paper[row][col]

    for (i in row until row + size){
        for (j in col until col + size){
            if(first != paper[i][j]) return false
        }
    }

    return true
}