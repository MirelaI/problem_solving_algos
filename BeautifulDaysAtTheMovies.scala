import Math.abs

object BeautifulDaysAtTheMovies {

    def beautifulDays(startPoint: Int, endPoint: Int, divisor: Int): Int = {
        val range = List.range(startPoint, endPoint + 1)
        divisor match { 
            case 0 => throw new IllegalArgumentException("Divisor argument should be greater than 0")
            case 1 => range.size
            case _ =>
                var beautifulDays = 0
                for (day <- startPoint to endPoint ) yield {
                    val reverse = (day+"").reverse.toInt
                    if (abs(day - reverse) % divisor == 0) {
                        day
                    }
                }
                beautifulDays
        }  
    }

    def main(args: Array[String]): Unit = {
        val stdin = scala.io.StdIn

       val ijk = stdin.readLine.split(" ")

        val i = ijk(0).trim.toInt
        val j = ijk(1).trim.toInt
        val k = ijk(2).trim.toInt

        val result = beautifulDays(i, j, k)
        println(result)
    }
}