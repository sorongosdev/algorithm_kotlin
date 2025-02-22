import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    bw.write("${(1L shl n) - 1}\n")

    hanoi(n, 1, 3, 2, bw)

    bw.flush()
    bw.close()
    br.close()
}

fun hanoi(n: Int, start: Int, end: Int, mid: Int, bw: BufferedWriter) {
    if(n == 1) {
        bw.write("$start $end\n")
        return
    }

    hanoi(n-1, start, mid, end, bw)
    bw.write("$start $end\n")
    hanoi(n-1, mid, end, start, bw)
}