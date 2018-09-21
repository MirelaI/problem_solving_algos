

object DaysOfTheProgramer {
    final val months = List(
        31,
        28,
        31,
        30,
        31,
        30,
        31,
        31,
        30,
        31,
        30,
        31
    )

    final val programerDay: Int = 256

    def dayOfProgrammer(year: Int): String = {
        val start = if (isLeapYear(year)) 1 else 0
        val month = "%02d".format((programerDay.toDouble / 30).ceil.toInt)
        val sum = months.foldLeft(start)( (a, b) => { if ( a + b < programerDay) a + b else a})
        val day = "%02d".format((programerDay - sum).toInt)
        Seq(day, month, year).mkString(".")
    }

    def isLeapYear(year: Int): Boolean = {
        year match {
            case y: Int if (year < 1918 &&  year > 1700) =>
                // Divisible by 400
                (y % 400 == 0 ) ||
                // Divisible by 
                (y % 4 == 0 && y % 100 != 0)
            case _ => year % 4 == 0 
        }
    }

    def main(args: Array[String]): Unit = {
        val std = scala.io.StdIn
        val year = std.readLine.trim.toInt
        val result = dayOfProgrammer(year)

        println(result)
    }
}