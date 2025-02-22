fun main() {
    // 정점 수 n과 간선 수 m 입력
    val (n, m) = readln().split(" ").map { it.toInt() } // 5,9

    val adj = Array(n+1){mutableListOf<Int>()}
    val adjR = Array(n+1){mutableListOf<Int>()}

    repeat(m){
        val (x,y) = readln().split(" ").map{it.toInt()}
        adj[x].add(y)
        adjR[y].add(x)
    }

    val (s, t) = readln().split(" ").map { it.toInt() }


    fun dfs(now: Int, adj: Array<MutableList<Int>>, visited: BooleanArray){
        if (visited[now]) return
        visited[now] = true
        for (neighbor in adj[now]){
            dfs(neighbor, adj, visited)
        }
    }

    val fromS = BooleanArray(n+1)
    fromS[t] = true
    dfs(s,adj,fromS)

    val toS = BooleanArray(n+1)
    dfs(s,adjR,toS)

    val fromT = BooleanArray(n+1)
    fromT[s] = true
    dfs(t,adj,fromT)

    val toT = BooleanArray(n+1)
    dfs(t,adjR,toT)
}