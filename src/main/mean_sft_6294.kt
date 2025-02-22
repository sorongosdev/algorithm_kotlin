import java.text.DecimalFormat

fun main(){
    val (n,k) = readln().split(" ").map{it.toInt()}
    val answer = DoubleArray(k){0.0}

    val score = readln().split(" ").map{it.toDouble()}.toDoubleArray()

    for (i in 0 until k){
        val (start,end) = readln().split(" ").map{it.toInt()}

        val sliceSum = score.slice(start-1 until end).sum()

        answer[i] = String.format("%.2f",sliceSum/(end-start+1)).toDouble()
    }

    answer.forEach{
        println(String.format("%.2f", it))
    }
}