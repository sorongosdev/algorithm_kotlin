fun main() {
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    val base = numbers[0]
    val exponent = numbers[1]
    val mod = numbers[2]

    print(power(base, exponent, mod))
}

fun power(base: Int, exponent: Int, mod: Int): Int {
    if (exponent == 0) return 1

    // 지수를 반으로 나눔
    val half = power(base, exponent / 2, mod)

    return if (exponent % 2 == 0) {
        // 지수가 짝수일 때
        (1L * half * half % mod).toInt()
    } else {
        // 지수가 홀수일 때
        (1L * half * half % mod * base % mod).toInt()
    }
}