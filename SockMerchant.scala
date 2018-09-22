
object SockMerchant {

  def sockMerchant(totalSocks: Int, socks: Array[Int]): Int = {
    socks.groupBy(identity)
      .map { case (x,y) => x -> y.size}
      .values
      .foldLeft(0) { (sum, toAdd) =>
        sum + toAdd / 2
      }
  }

  def main (args: Array[String]): Unit = {
      val stdIn = scala.io.StdIn

      val noOfSocks = stdIn.readLine.trim.toInt

      val socks = stdIn.readLine.split(" ").map(_.trim.toInt)
      val result = sockMerchant(noOfSocks, socks)

      println(result)
  }
}