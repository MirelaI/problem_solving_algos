object UtopianTree {

    // Complete the utopianTree function below.
    def utopianTree(n: Int): Int = {
        ...

    }

    def main(args: Array[String]): Unit = {
        val stdin = scala.io.StdIn

        val t = stdin.readLine.trim.toInt

        for (tItr <- 1 to t) {
            val n = stdin.readLine.trim.toInt

            val result = utopianTree(n)

            println(result)
        }
    }
}