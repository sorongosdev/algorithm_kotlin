import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Pic_bj_1926KtTest {
    @Test
    fun `입력 테스트1`() {
        val input = "6 5\n" +
                "1 1 0 1 1\n" +
                "0 1 1 0 0\n" +
                "0 0 0 0 0\n" +
                "1 0 1 1 1\n" +
                "0 0 1 1 1\n" +
                "0 0 1 1 1"
        val expectedOutput = "4\n" +
                "9"
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
            val mainClass = Class.forName("Pic_bj_1926Kt")
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