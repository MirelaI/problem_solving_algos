import java.io._

object Solution {

    def withinDistance(
        point: Int, startPoint: Int, startPointHouse: Int, endPointHouse: Int
    ) = { 
        (point + startPoint) match {
            case distance 
                if (startPointHouse <= distance && endPointHouse >= distance ) => true
            case _ => false
        }
    }     

    // Complete the countApplesAndOranges function below.
    def countApplesAndOranges(
        startPointHouse: Int, 
        endPointHouse: Int, 
        appleTreeLocation: Int, 
        orangeTreeLocation: Int, 
        apples: Array[Int], 
        oranges: Array[Int]
    ): List[Int] = {
        // # of apples within distance
        val applesWithinDistance = apples
            .map {withinDistance(_, appleTreeLocation, startPointHouse, endPointHouse)}
            .filter { _ == true }.size

        // # of oranges within distance
        val orangesWithDistance = oranges
            .map {withinDistance(_, orangeTreeLocation, startPointHouse, endPointHouse)}
            .filter { _ == true }.size

        List(applesWithinDistance,orangesWithDistance)
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn
        val st = stdin.readLine.split(" ")

        val s = st(0).trim.toInt
        val t = st(1).trim.toInt

        val ab = stdin.readLine.split(" ")

        val a = ab(0).trim.toInt
        val b = ab(1).trim.toInt

        val mn = stdin.readLine.split(" ")

        val m = mn(0).trim.toInt
        val n = mn(1).trim.toInt

        val apples = stdin.readLine.split(" ").map(_.trim.toInt)
        val oranges = stdin.readLine.split(" ").map(_.trim.toInt)
        val result = countApplesAndOranges(s, t, a, b, apples, oranges)
        result.foreach(println(_))
    }
}
