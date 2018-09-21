

object DaysOfTheProgramer {
    val months = List(
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

    val programerDay: Int = 256

    def dayOfProgrammer(year: Int): String = {
        val start = if (isLeapYear(year)) 1 else 0
        val month = "%02d".format((programerDay.toDouble / 30).ceil.toInt)

        val sum = months.foldLeft(start)( (a, b) => { if ( a + b < programerDay) a + b else a})

        // Extra days if the year is 1918: Feb 14th was the 32nd day of the year (1st of Feb)
        val daysToAdd: Int = if (year == 1918) 13 else 0 // 14th of feb to become 1st of feb
        val day = "%02d".format((programerDay - sum + daysToAdd).toInt)


        Seq(day, month, year).mkString(".")
    }

    def isLeapYear(year: Int): Boolean = {
        year match {
            case y: Int if (year > 1917) =>
                y % 4 == 0
            case _ =>
                // Divisible by 400
                (year % 400 == 0 ) ||
                // Divisible by
                (year % 4 == 0 && year % 100 != 0)
        }
    }

    def main(args: Array[String]): Unit = {
        val std = scala.io.StdIn
        val year = std.readLine.trim.toInt
        val result = dayOfProgrammer(year)

        println(result)
    }
}