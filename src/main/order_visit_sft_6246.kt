fun dfs(
    a: Int, b: Int,
    checkpointIndex: Int,
    n: Int,
    grid: Array<IntArray>,
    checkPoints: List<Pair<Int,Int>>,
    visited: Array<BooleanArray>,
    pathCount: IntArray
){
    // 현재 위치가 체크 포인트
    if (a == checkPoints[checkpointIndex].first -1 && b == checkPoints[checkpointIndex].second - 1){
        // 마지막 체크 포인트
        if (checkpointIndex == checkPoints.size - 1){
            pathCount[0] ++
            return
        }
        // 다음 체크 포인트 찾아 진행
        dfs(a,b,checkpointIndex + 1, n, grid, checkPoints, visited, pathCount)
        return
    }

    // 상하좌우 이동
    val dx = intArrayOf(-1,1,0,0)
    val dy = intArrayOf(0,0,-1,1)

    for (i in 0..3){
        val nx = a + dx[i]
        val ny = b + dy[i]

        // 범위 안이고, 벽이 아니며, 방문하지 않은 경우 방문 처리
        if(nx in 0 until n && ny in 0 until n && grid[nx][ny] == 0 && !visited[nx][ny]){
            visited[nx][ny] = true
            dfs(nx,ny,checkpointIndex, n, grid, checkPoints, visited, pathCount)
            visited[nx][ny] = false // 다음 체크 포인트에서는 false로 변경
        }
    }
}

fun main(){
    val (n,m) = readln().split(" ").map{it.toInt()}

    val grid = Array(n){
        readln().split(" ").map{it.toInt()}.toIntArray()
    }

    val checkPoints = List(m){
        val (a,b) = readln().split(" ").map{it.toInt()}
        Pair(a,b)
    }

    val visited = Array(n) { BooleanArray(n) }

    val pathCount = IntArray(1)

    val start = checkPoints[0]
    visited[start.first - 1][start.second - 1] = true

    dfs(start.first - 1, start.second - 1, 0, n, grid, checkPoints, visited, pathCount)

    println(pathCount[0])
}