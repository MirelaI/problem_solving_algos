import scala.io._

/*
Lily has a chocolate bar that she wants to share it with Ron for his birthday.
Each of the squares has an integer on it. She decides to share a contiguous 
segment of the bar selected such that the length of the segment matches Ron's
birth month and the sum of the integers on the squares is equal to his birth
day. You must determine how many ways she can divide the chocolate.
*/

object BirthdayChocolate {

    def findSquaresSequence(squares: Array[Int], day: Int, month: Int): Int = {
        println(s"Day: $day")
        println(s"Month: $month")
        (squares.size) match {
            case endIndex: Int if endIndex > 0 => 
                (0 until endIndex).map { i: Int => 
                    squares.slice(i, i + month).sum
                }.filter { _ == day }.size
            case _ => 0
        }
    }

    def main(args: Array[String]): Unit = {
        val n = StdIn.readLine.trim.toInt

        val squares = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
        val dayMonth = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

        val day = dayMonth(0).toInt
        val month = dayMonth(1).toInt

        val result = findSquaresSequence(squares, day, month)

        println(result)
    }
}