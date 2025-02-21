fun main(){
    val n = readLine()!!.toInt()

    var r = 2
    if (n == 1) {
        r = 1
        println(r)
    }
    else {
        while (true) {
            val minVal = 2 + 3 * (r - 2) * (r - 1)
            val maxVal = 1 + 3 * (r - 1) * (r)

            if (n in minVal..maxVal) {
                break
            } else {
                r ++
            }
        }
        println(r)
    }
}