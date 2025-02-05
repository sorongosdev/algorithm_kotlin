import java.util.*

fun bfs(x: Int, y: Int, visited: Array<BooleanArray>, paper: Array<IntArray>,n: Int,m: Int): Int{
    val dx = intArrayOf(-1,1,0,0)
    val dy = intArrayOf(0,0,-1,1)
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    queue.offer(Pair(x,y)) // 처음 값을 넣어줌.
    visited[x][y] = true
    var size = 1

    while (queue.isNotEmpty()){
        val (curX,curY) = queue.poll()

        for(i in 0 until 4){
            val nx = curX + dx[i]
            val ny = curY + dy[i]

            if (nx in 0 until n && ny in 0 until m && visited[nx][ny] != true && paper[nx][ny] == 1){
                queue.offer(Pair(nx,ny))
                visited[nx][ny] = true
                size ++
            }
        }
    }
    return size
}

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val paper = Array(n){IntArray(m)}

    for (i in 0 until n){
        paper[i] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    val visited = Array(n){BooleanArray(m)}

    var picCount = 0
    var maxSize = 0

    for (i in 0 until n){ // 행
        for (j in 0 until m){ // 열
            if(!visited[i][j] && paper[i][j] == 1){
                picCount ++
                maxSize = maxOf(maxSize, bfs(i,j,visited,paper,n,m))
            }
        }
    }

    println(picCount)
    println(maxSize)
}