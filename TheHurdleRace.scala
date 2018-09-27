
object TheHurdleRace {

    def hurdleRace(capacity: Int, heights: Array[Int]): Int = {
        val totalPotions = heights.max - capacity

        if (totalPotions > 0) totalPotions else 0
    }

    def main(args: Array[String]): Unit = {
        val stdin = scala.io.StdIn 

        val nk = stdin.readLine.split(" ")
        val hurdles = nk(0).trim.toInt

        val capacity = nk(1).trim.toInt

        val heights = stdin.readLine.split(" ").map(_.trim.toInt)
        val result = hurdleRace(capacity, heights)

        println(result)
    }
}