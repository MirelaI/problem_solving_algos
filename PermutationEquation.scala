object PermutationEquation {
    def permutationEquation(p: Array[Int]) = {
        // add here the implementation
    }

    def main(args: Array[String]): Unit = {
        val stdin = scala.io.StdIn

        val n = stdin.readLine.trim.toInt

        val p = stdin.readLine.split(" ").map(_.trim.toInt)
        val result = permutationEquation(p)

        println(result)
    }
}