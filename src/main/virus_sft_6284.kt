fun main(){
    val (k,p,n) = readln().split(" ").map{it.toLong()}
    var result = k
    val mod = 1000000007L

    repeat(n.toInt()){
        result = (result * p) % mod
    }

    println(result)
}