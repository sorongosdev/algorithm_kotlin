fun main() {
    val n = 19
    val board = Array(n) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

    // 하(↓), 우하(⬊), 우(➞), 우상(⬈)
    val dx = intArrayOf(1, 1, 0, -1)
    val dy = intArrayOf(0, 1, 1, 1)

    fun omok(): Triple<Int, Int, Int> {
        for (x in 0 until n) {
            for (y in 0 until n) {
                if (board[x][y] != 0) {
                    for (i in 0..3) {
                        var nx = x + dx[i]
                        var ny = y + dy[i]
                        var cnt = 1

                        // 다음 위치가 범위를 벗어나면 이 방향은 더 이상 체크하지 않음
                        if (nx !in 0 until n || ny !in 0 until n) {
                            continue
                        }

                        // 연속된 같은 색 바둑알 체크
                        while (nx in 0 until n && ny in 0 until n && board[x][y] == board[nx][ny]) {
                            cnt++

                            if (cnt == 5) {
                                // 육목 체크 1: 현재 방향으로 한 칸 더 갔을 때 같은 색이면 육목
                                // nx 가려는 방향 마지막 점
                                if (nx + dx[i] in 0 until n && ny + dy[i] in 0 until n &&
                                    board[nx][ny] == board[nx + dx[i]][ny + dy[i]]) {
                                    break
                                }
                                // 육목 체크 2: 시작점에서 반대 방향으로 한 칸 갔을 때 같은 색이면 육목
                                // x 시작점
                                if (x - dx[i] in 0 until n && y - dy[i] in 0 until n &&
                                    board[x][y] == board[x - dx[i]][y - dy[i]]) {
                                    break
                                }
                                return Triple(board[x][y], x + 1, y + 1)  // 오목인 경우
                            }

                            nx += dx[i]
                            ny += dy[i]
                        }
                    }
                }
            }
        }
        return Triple(0, -1, -1)  // 승부가 나지 않은 경우
    }

    val (color, x, y) = omok()
    if (color == 0) {
        println(color)
    } else {
        println(color)
        println("$x $y")
    }
}