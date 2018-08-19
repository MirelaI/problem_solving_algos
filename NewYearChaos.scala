import Math.abs
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Map

object Solution {

    // Complete the minimumBribes function below.
    def minimumBribes(q: Array[Int]): Option[Int] = {
        val peopleInTheQueue = q.toBuffer
        var swaps: Int = 0
        var swaped: Boolean = false
        var lastIndex: Int = q.size - 1
        
        // Find first if is too chaotic
        for ( i <- 0 until peopleInTheQueue.size - 1 ) {
            val pers = peopleInTheQueue(i)
            val bribed = (pers - 1) - i
            if ( bribed > 2 ) return None
        }

        for (i <- 0 to lastIndex) {
            for ( j <- 0 until lastIndex )  {
                if (peopleInTheQueue(j) > peopleInTheQueue(j+1)) {
                    val temp = peopleInTheQueue(j)
                    peopleInTheQueue(j) = peopleInTheQueue(j + 1)
                    peopleInTheQueue(j + 1) = temp
                    swaps += 1
                    swaped = true
                } 
            }
            if (swaped) {
                swaped = false
                lastIndex -= 1
            } else {
                lastIndex = i + 1
            }
        }

        Some(swaps)
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val t = stdin.readLine.trim.toInt

        for (tItr <- 1 to t) {
            val n = stdin.readLine.trim.toInt

            val q = stdin.readLine.split(" ").map(_.trim.toInt)
            minimumBribes(q) match {
                case Some(x: Int) => println(x) 
                case _ => println("Too chaotic")
            }
        }
    }
}