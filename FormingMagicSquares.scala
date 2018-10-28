import scala.collection.mutable.ArrayBuffer

object Solution {

    // Complete the formingMagicSquare function below.
    def formingMagicSquare(square: Array[Array[Int]]): Int = {
        // This fugly part should be extracted in another method where the
        // magic squares are generated based on an algo and we cache the result
        // to optimize further runs of the solution
        val possibleMagicSquares: List[List[List[Int]]] = List(
            List(List(8, 1, 6), List(3, 5, 7), List(4, 9, 2)),
            List(List(6, 1, 8), List(7, 5, 3), List(2, 9, 4)),
            List(List(4, 9, 2), List(3, 5, 7), List(8, 1, 6)),
            List(List(2, 9, 4), List(7, 5, 3), List(6, 1, 8)), 
            List(List(8, 3, 4), List(1, 5, 9), List(6, 7, 2)),
            List(List(4, 3, 8), List(9, 5, 1), List(2, 7, 6)), 
            List(List(6, 7, 2), List(1, 5, 9), List(8, 3, 4)), 
            List(List(2, 7, 6), List(9, 5, 1), List(4, 3, 8))
        )

        var totals = ArrayBuffer[Int]()
        for (preCalculatedMagicSquare <- possibleMagicSquares) {
            var total = 0
            for ((pRow, sRow) <- preCalculatedMagicSquare zip square) {
                for ( (pValue, sValue) <- pRow zip sRow) {
                    if (pValue != sValue) {
                        total += Math.abs(pValue - sValue)
                    }
                }
            }
            
            totals.append(total)
        }

        totals.min
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val s = Array.ofDim[Int](3, 3)

        for (i <- 0 until 3) {
            s(i) = stdin.readLine.split(" ").map(_.trim.toInt)
        }

        val result = formingMagicSquare(s)

        println(result)
    }
}