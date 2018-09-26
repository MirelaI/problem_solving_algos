import scala.collection.mutable.ArrayBuffer
import Math.abs

object PickingNumbers {

    def pickingNumbers(list: Array[Int], n: Int): Int = {
        val sortedList: Array[Int] = list.sorted
        val listOfArrays: ArrayBuffer[ArrayBuffer[Int]] = new ArrayBuffer()

        var tempArray: ArrayBuffer[Int] = new ArrayBuffer()
        //Have a starting point
        tempArray += sortedList(0)
    
        for (i <- 0 until n) {
            val currentElem = sortedList(i)

            val isBigDifference = tempArray.exists ( el => abs(el - currentElem) > 1)

            if (isBigDifference) {
                listOfArrays += tempArray
                // Setup a new starting point
                tempArray = ArrayBuffer(currentElem)
            } else {
                tempArray += currentElem
            } 

            // When is the right time to push into the queue
            if (i == n -1 ) listOfArrays += tempArray
        }

        listOfArrays.map { _.size}.sorted.last
    }

    def main(args: Array[String]): Unit = {
        val stdin = scala.io.StdIn 

        val n = stdin.readLine.trim.toInt

        val a = stdin.readLine.split(" ").map(_.trim.toInt)
        val result = pickingNumbers(a, n)

        println(result)
    }
}