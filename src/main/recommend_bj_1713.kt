fun main() {
    val n = readLine()!!.toInt() // 사진틀 개수
    val recommend_num = readLine()!!.toInt() // 추천 수

    // 추천 목록
    val recommend = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    // 사진 틀
    var catalog = ArrayDeque<Pair<Int, Int>>()

    for (i in 0 until recommend_num) {
        val firstArray = catalog.map { it.first }.toIntArray()
        if (recommend[i] in firstArray) { // 카탈로그에 있다면
            // 그 값을 찾아서 그 인덱스에 + 1
            val index = firstArray.indexOf(recommend[i])
            catalog[index] = Pair(catalog[index].first, catalog[index].second + 1)
        } else { // 카탈로그에 없다면
            if (catalog.size == n) { // 카탈로그 사이즈가 n
                val minCount = catalog.minOf{it.second}
                // 추천수가 적은 것중 제일 오래된 인덱스
                val removeIndex = catalog.indexOfFirst{it.second == minCount}
                // 제거
                catalog.removeAt(removeIndex)
            }

            catalog.add(Pair(recommend[i], 1))
        }
    }

    val gallery = catalog.sortedWith(compareBy{it.first})

    println(gallery.map{it.first}.joinToString(" "))
}