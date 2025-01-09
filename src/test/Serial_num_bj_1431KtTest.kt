import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Serial_num_bj_1431KtTest {
    @Test
    fun `시리얼 번호 정렬 테스트1`() {
        val input = "5\nABCD\n145C\nA\nA910\nZ321"
        val expectedOutput = "A\nABCD\nZ321\n145C\nA910\n"  // 마지막 \n 제거
        testWithInputAndOutput(input, expectedOutput)
    }
    @Test
    fun `시리얼 번호 정렬 테스트2`() {
        val input = "2\nZ19\nZ20"
        val expectedOutput = "Z20\nZ19"  // 마지막 \n 제거
        testWithInputAndOutput(input, expectedOutput)
    }

    @Test
    fun `시리얼 번호 정렬 테스트3`() {
        val input = "4\n" +
                "34H2BJS6N\n" +
                "PIM12MD7RCOLWW09\n" +
                "PYF1J14TF\n" +
                "FIPJOTEA5"
        val expectedOutput = "FIPJOTEA5\n" +
                "PYF1J14TF\n" +
                "34H2BJS6N\n" +
                "PIM12MD7RCOLWW09"  // 마지막 \n 제거
        testWithInputAndOutput(input, expectedOutput)
    }

    @Test
    fun `시리얼 번호 정렬 테스트4`() {
        val input = "5\n" +
                "ABCDE\n" +
                "BCDEF\n" +
                "ABCDA\n" +
                "BAAAA\n" +
                "ACAAA"
        val expectedOutput = "ABCDA\n" +
                "ABCDE\n" +
                "ACAAA\n" +
                "BAAAA\n" +
                "BCDEF"  // 마지막 \n 제거
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
            val mainClass = Class.forName("Serial_num_bj_1431Kt")
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