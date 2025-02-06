fun main(){
    val (n,m) = readln().split(" ").map{it.toInt()}
    val peopleArray: Array<IntArray> = Array(n){intArrayOf()}
    var count = 0

    for(i in 0 until n){
        val row = readln().split(" ").map{it.toInt()}
        peopleArray[i] = row.toIntArray()
    }

    val (l1,r1) = readln().split(" ").map{it.toInt()}
    val (l2,r2) = readln().split(" ").map{it.toInt()}

    kill(l1-1,r1-1,m,peopleArray)
    kill(l2-1,r2-1,m,peopleArray)

    peopleArray.forEach{
        it.map{ item->
            if (item==1) count ++
        }
    }

    println(count)
}

fun kill(l: Int,r: Int,m: Int,peopleArray: Array<IntArray>){
    for (i in l .. r){
        for (j in 0 until m){
            if(peopleArray[i][j] == 1){
                peopleArray[i][j] = 0
                break
            }
        }
    }
}