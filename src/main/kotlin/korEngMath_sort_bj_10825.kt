package main.kotlin

data class Student(
    val name: String,
    val kor: Int,
    val eng: Int,
    val math: Int,
)

fun main() {
    val n = readln().toInt()
    val studentList = mutableListOf<Student>()

    repeat(n) {
        val (name, kor, eng, math) = readln().split(" ")
        studentList.add(Student(name, kor.toInt(), eng.toInt(), math.toInt()))
    }

    val sortedStudentList = studentList.sortedWith(
        compareByDescending<Student> { it.kor }
            .thenBy { it.eng }
            .thenByDescending { it.math }
            .thenBy { it.name }
    )

    sortedStudentList.forEach{
        println(it.name)
    }
}