
object ViralAdvertising {
    def viralAdvertising(n: Int): Int = { 
        var recipients = 5
        List.range(1, n + 1).foldLeft(0) { (totalLikes, _) => 
            val likes = recipients/2
            recipients = likes * 3
            totalLikes + likes
        }
    }

    def main(args: Array[String]): Unit = {
        val stdin = scala.io.StdIn 
        val n = stdin.readLine.trim.toInt

        val result = viralAdvertising(n)
        println(result)
    }
}