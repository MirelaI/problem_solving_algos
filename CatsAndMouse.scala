import Math.abs

object CatsAndMouse {

    def catAndMouse(catA: Int, catB: Int, mousePoint: Int): String = {
        val catsDistanceFromJerry = Map(
            "Cat A" -> abs(catA - mousePoint), 
            "Cat B" -> abs(catB - mousePoint)
            // can be added as many cats as needed
        )
        
        if (catsDistanceFromJerry.values.toList.distinct.length == 1) {
            "Mouse C"
        } else {
            catsDistanceFromJerry.toList.sortWith(_._2 < _._2)(0)._1
        }
    }

    def main(args: Array[String]): Unit = {
        val stdin = scala.io.StdIn

        val q = stdin.readLine.trim.toInt

        for (qItr <- 1 to q) {
            val xyz = stdin.readLine.split(" ")

            val x = xyz(0).trim.toInt
            val y = xyz(1).trim.toInt
            val z = xyz(2).trim.toInt

            val result = catAndMouse(x, y, z)

            println(result)
        }
    }
}