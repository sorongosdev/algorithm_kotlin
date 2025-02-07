fun main() {
    // n: DNA 문자열의 개수, m: 각 DNA 문자열의 길이
    val (n, m) = readln().split(" ").map { it.toInt() }

    // DNA 문자열들을 입력받아 배열에 저장
    val dna = Array(n) { readln() }

    // 2^n 크기의 배열로, 각 비트마스크 상태에서의 병합된 DNA 저장
    // 초기 상태(0)는 모두 '.'으로 초기화
    val superDNA = Array(1 shl n) { if (it == 0) ".".repeat(m).toList() else null }

    // 두 DNA 문자열을 병합하는 함수
    fun merge(dna1: List<Char>?, dna2: String): List<Char>? {
        // dna1이 null이면 병합 불가능
        if (dna1 == null) return null
        val result = mutableListOf<Char>()

        for (i in 0 until m) {
            when {
                dna1[i] == '.' -> result.add(dna2[i])  // dna1이 와일드카드면 dna2 문자 사용
                dna2[i] == '.' -> result.add(dna1[i])  // dna2가 와일드카드면 dna1 문자 사용
                dna1[i] == dna2[i] -> result.add(dna1[i])  // 두 문자가 같으면 그 문자 사용
                else -> return null  // 다른 문자면 병합 불가능
            }
        }
        return result
    }

    // 현재 비트마스크에 대한 superDNA를 생성하는 함수
    fun genSuperDNA(index: Int) {
        // 현재 비트마스크에서 가장 낮은 위치의 1비트 찾기
        val loc = index and -index
        // 그 비트의 위치(0부터 시작)를 계산
        val pos = loc.toString(2).length - 1
        // 현재 index의 superDNA를 계산해서 저장
        superDNA[index] = merge(superDNA[index - loc], dna[pos])
    }

    // 현재 비트마스크 상태에서 필요한 최소 그룹 수를 계산하는 함수
    fun genAnswer(index: Int, answer: IntArray): Int {
        // 이미 계산된 상태면 그 값을 반환
        if (answer[index] <= n) return answer[index]

        var subset = index
        var minAnswer = n + 1

        // 현재 비트마스크의 모든 부분집합을 순회하며 최소값 찾기
        while (subset > 0) {
            val complement = index and subset.inv()  // 현재 부분집합의 여집합 계산
            val temp = answer[subset] + answer[complement]  // 부분집합과 여집합의 답을 더한 값
            minAnswer = minOf(minAnswer, temp)  // 최소값 갱신
            subset = (subset - 1) and index  // 다음 부분집합 계산
        }

        answer[index] = minAnswer  // 찾은 최소값을 저장
        return minAnswer
    }

    // DP 배열 초기화: 모든 상태를 불가능한 값(n+1)로 설정
    val answer = IntArray(1 shl n) { n + 1 }
    answer[0] = 0  // 빈 집합은 0개의 그룹 필요

    // 모든 비트마스크에 대해
    // superDNA가 존재하면 1개 그룹으로 가능
    // 아니면 부분문제로 나눠서 해결
    for (i in 1 until (1 shl n)) {
        genSuperDNA(i)
        answer[i] = if (superDNA[i] != null) 1 else genAnswer(i, answer)
    }

    // 모든 DNA를 포함하는 경우(2^n-1)의 최소 그룹 수 출력
    println(answer[(1 shl n) - 1])
}