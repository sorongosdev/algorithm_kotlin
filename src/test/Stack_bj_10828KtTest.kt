import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Stack_bj_10828KtTest{
    @Test
    fun `스택 테스트1`() {
        val input = "14\n" +
                "push 1\n" +
                "push 2\n" +
                "top\n" +
                "size\n" +
                "empty\n" +
                "pop\n" +
                "pop\n" +
                "pop\n" +
                "size\n" +
                "empty\n" +
                "pop\n" +
                "push 3\n" +
                "empty\n" +
                "top"
        val expectedOutput = "2\n" +
                "2\n" +
                "0\n" +
                "2\n" +
                "1\n" +
                "-1\n" +
                "0\n" +
                "1\n" +
                "-1\n" +
                "0\n" +
                "3"
        testWithInputAndOutput(input, expectedOutput)
    }

    @Test
    fun `스택 테스트2`() {
        val input = "7\n" +
                "pop\n" +
                "top\n" +
                "push 123\n" +
                "top\n" +
                "pop\n" +
                "top\n" +
                "pop"
        val expectedOutput = "-1\n" +
                "-1\n" +
                "123\n" +
                "123\n" +
                "-1\n" +
                "-1"
        testWithInputAndOutput(input, expectedOutput)
    }

    private fun testWithInputAndOutput(input: String, expectedOutput: String) {
        val inputStream = ByteArrayInputStream(input.toByteArray())
        val outputStream = ByteArrayOutputStream()
        val originalIn = System.`in`
        val originalOut = System.out

        System.setIn(inputStream)
        System.setOut(PrintStream(outputStream))

        try {
            val mainClass = Class.forName("Stack_bj_10828Kt")
            val mainMethod = mainClass.getDeclaredMethod("main")
            mainMethod.invoke(null)

            val actualOutput = outputStream.toString().replace("\r\n", "\n").trim()
            val normalizedExpectedOutput = expectedOutput.replace("\r\n", "\n").trim()
            assertEquals(normalizedExpectedOutput, actualOutput)
        } finally {
            System.setIn(originalIn)
            System.setOut(originalOut)
        }
    }
}