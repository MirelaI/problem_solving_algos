object SaveThePrisoner {

    // Complete the saveThePrisoner function below.
    // Example: 5 2 2
    // Result: (2 - 2 + 2) % 5 + 1  -> 2
    def saveThePrisoner(prisonersNo: Int, sweetsNo: Int, chair: Int): Int = {
        (sweetsNo - 2 + chair) % prisonersNo + 1
    }

    def main(args: Array[String]): Unit = {
        val stdin = scala.io.StdIn

        val t = stdin.readLine.trim.toInt

        for (tItr <- 1 to t) {
            val nms = stdin.readLine.split(" ")

            val n = nms(0).trim.toInt
            val m = nms(1).trim.toInt
            val s = nms(2).trim.toInt

            val result = saveThePrisoner(n, m, s)

            println(result)
        }
    }
}