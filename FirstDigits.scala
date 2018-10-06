
object FirstDigits {

    // Complete the findDigits function below.
    def findDigits(n: Int): Int = {
        n.toString
            .split("")
            .filter { digit: String => 
                digit.toInt != 0 && n % digit.toInt == 0
            }
            .size
    }

    def main(args: Array[String]): Unit = {
        val stdin = scala.io.StdIn 

        val t = stdin.readLine.trim.toInt

        for (tItr <- 1 to t) {
            val n = stdin.readLine.trim.toInt

            val result = findDigits(n)

            println(result)
        }
    }
}