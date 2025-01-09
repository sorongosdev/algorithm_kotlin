fun main(){
    val n = readln().toInt()
    val stack = mutableListOf<Int>()

    repeat(n){
        val input = readln().split(" ")
        val order = input[0]
        when(order){
            "push" -> {
                stack.add(input[1].toInt())
            }
            "top" -> {
                if(stack.isEmpty()){
                    println(-1)
                } else{
                    println(stack.last())
                }
            }
            "size" -> {
                println(stack.size)
            }
            "empty" -> {
                val result = if(stack.isEmpty()) 1 else 0
                println(result)
            }
            "pop" -> {
                if(stack.isEmpty()){
                    println(-1)
                } else{
                    println(stack.last())
                    stack.removeAt(stack.size-1)
                }
            }
        }
    }
}