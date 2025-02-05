fun main(){
    val numbers = readln().split(" ").map{it.toInt()}

    if (numbers.sortedBy{it} == numbers){
        println("ascending")
    } else if(numbers.sortedByDescending{it} == numbers){
        println("descending")
    } else{
        println("mixed")
    }
}