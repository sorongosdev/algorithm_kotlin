fun main(){
    val (n,r,c) = readLine()!!.split(" ").map{it.toInt()}

    println(visit(n,r,c))
}

fun visit(n: Int, r: Int,c: Int): Int{
    if (n==0){
        return 0
    }

    val half = 1 shl (n - 1) // 2^(n-1)

    return when{
        // 1사분면
        r < half && c < half -> visit(n-1, r, c)
        // 2사분면
        r < half && c >= half -> half * half + visit(n-1,r,c-half)
        // 3사분면
        r >= half && c < half -> 2 * half * half + visit(n-1,r-half,c)
        // 4사분면
        else -> 3 * half * half + visit(n-1,r-half,c-half)
    }
}