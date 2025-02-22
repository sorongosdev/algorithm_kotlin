fun main(){
    val n = readLine()!!.toInt()

    val paper = Array(n){IntArray(n)}

    val count = IntArray(2)

    for (i in 0 until n){
        paper[i] = readLine()!!.split(" ").map{it.toInt()}.toIntArray()
    }

    visit(n,0,0,count,paper)

    println(count[0])
    println(count[1])
}

fun visit(size: Int, row: Int, col: Int, count:IntArray, paper: Array<IntArray>){
    if (checkSame(size,row,col,paper)){
        val index = paper[row][col]
        count[index] ++
        return
    }

    val newSize = size/2

    for (i in 0 until 2){
        for (j in 0 until 2){
            visit(
                newSize,
                row + newSize * i,
                col + newSize * j,
                count,
                paper
            )
        }
    }
}

fun checkSame(size: Int,row: Int, col: Int, paper: Array<IntArray>): Boolean{
    val first = paper[row][col]

    for (i in row until row + size){
        for (j in col until col + size){
            if (first != paper[i][j]){
                return false
            }
        }
    }

    return true
}