object PermutationEquation {
    def permutationEquation(p: Array[Int]) = {
        val pToMap = p.zipWithIndex.toMap
        (1 to p.size) map { el: Int => 
            pToMap(pToMap(el) + 1) + 1
        }
    }

    def main(args: Array[String]): Unit = {
        val stdin = scala.io.StdIn

        val n = stdin.readLine.trim.toInt

        val p = stdin.readLine.split(" ").map(_.trim.toInt)
        val result = permutationEquation(p)

        println(result)
    }
}