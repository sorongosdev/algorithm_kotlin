fun main(){
    val n = readLine()!!.toInt()

    val image = Array(n){IntArray(n)}

    for (i in 0 until n){
        image[i] = readLine()!!.map{it.toString().toInt()}.toIntArray()
    }

    divide(n,image,0,0)
}

fun divide(size: Int, image: Array<IntArray>, row: Int, col: Int){
    if(checkSame(size,image,row,col)){
        val common = image[row][col]
        print(common)
        return
    }

    val half = size/2

    print("(")
    for (i in 0 until 2){
        for (j in 0 until 2){
            divide(
                half,
                image,
                row + i * half,
                col + j * half,
            )
        }
    }
    print(")")
}

fun checkSame(size: Int, image: Array<IntArray>,row: Int,col: Int): Boolean{
    val first = image[row][col]

    for (i in row until row+size){
        for (j in col until col+size){
            if(first != image[i][j]) return false
        }
    }

    return true
}