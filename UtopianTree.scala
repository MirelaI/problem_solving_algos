object UtopianTree {

    // Complete the utopianTree function below.
    def utopianTree(n: Int): Int = {
        (0 until n).foldLeft(1){ (height, n) => 
            n match {
                case n if n % 2 == 0 => height * 2
                case _ => height + 1
            }        
        }
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