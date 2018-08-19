import scala.collection.mutable._


object BubbleSort {
    def sort(inputArray: List[Int]): List[Int] = {
        var sorted: Buffer[Int] = inputArray.toBuffer

        for ( i <- 0 until sorted.size ) {
            for ( j <- 0 until sorted.size - i - 1) {
                if ( sorted(j) > sorted(j+1) ) {
                    val temp = sorted(j)
                    sorted(j) = sorted(j+1)
                    sorted(j+1) = temp
                }
            }
        }

        sorted.toList
    }

    def main(args: Array[String]) = {
        val stdInput = scala.io.StdIn
        val inputArray = stdInput.readLine.trim.split("").map { _.toInt }.toList

        val sortedArray = sort(inputArray)
        println(sortedArray)
    }
}