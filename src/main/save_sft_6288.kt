fun main() {
    var (w, n) = readln().split(" ").map { it.toInt() }
    var answer = 0

    val metal = Array<Pair<Int, Int>>(n) { Pair(0, 0) }

    for (i in 0 until n) {
        val (m,p) = readln().split(" ").map { it.toInt() }
        metal[i] = Pair(m,p)
    }

    // 가격이 높은 순으로 정렬
    val sortedMetal = metal
        .sortedWith(
            compareByDescending { it.second }
        )

    while(w != 0){
        for (i in 0 until n){ // 각 금속 순회
            if(sortedMetal[i].first <= w){ // 70 <= 100
                answer += sortedMetal[i].first * sortedMetal[i].second // 70*2
                w -= sortedMetal[i].first // 30
            } else{
                answer += w * sortedMetal[i].second // 30 * 1
                w = 0 // 0
                break
            }
        }
    }

    print(answer)
    // 70*2 + 30*1 = 170
}