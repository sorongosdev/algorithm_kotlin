fun main(){
    val (n,w,l) = readLine()!!.split(" ").map{it.toInt()} // 4,2,10 // 1, 100, 100

    val cars = readLine()!!.split(" ").map{it.toInt()}.toMutableList()

    var time = 0
    var bridgeWeight = 0
    val bridge = ArrayDeque<Int>() // 다리위에 있는 각 차 무게
    val times = ArrayDeque<Int>() // 각 차가 언제 다리 위로 올라갔는지
    var truckIndex = 0

    // 다 건널때까지 반복
    while(truckIndex < n || bridge.isNotEmpty()){
        // 다리 위 트럭을 도착시킴
        if(bridge.isNotEmpty() && time - times.first() == w){
            bridgeWeight -= bridge.removeFirst()
            times.removeFirst()
        }

        // 새로운 트럭이 들어올 수 있는지 확인
        if(truckIndex < n && bridgeWeight + cars[truckIndex] <= l && bridge.size < w){
            bridge.addLast(cars[truckIndex])
            times.addLast(time)
            bridgeWeight += cars[truckIndex]
            truckIndex++
        }
        time ++
    }

    print(time)
}