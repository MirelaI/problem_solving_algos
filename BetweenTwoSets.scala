import java.io.PrintWriter

/*
You will be given two arrays of integers and asked to determine all integers that satisfy the following two conditions:

The elements of the first array are all factors of the integer being considered
The integer being considered is a factor of all elements of the second array
*/
object BetweenTwoSets {

    def getTotalX(a: Array[Int], b: Array[Int]): Int = {
        val start = a(a.length - 1)
        val end = b(b.length - 1)

        // Go through all the numbers considered
        val numbersFound = for (numberConsidered <- start to end) yield {
            val allElementsAreFactors = factorX(a, (x: Int) => { numberConsidered % x  == 0 } )
            val itFactorsAllElements = factorX(b, (x: Int) => { x % numberConsidered == 0 })

            if (allElementsAreFactors && itFactorsAllElements ) Some(numberConsidered)
            else None
        }

        numbersFound.flatten.size
    }

    def factorX(arr: Array[Int], factorMethod: Int => Boolean): Boolean = {
        val totalFactors = arr.map { factorMethod }.filter { _ == true }.size
        totalFactors == arr.size
    }

    def main(args: Array[String]) {
        val scan = scala.io.StdIn

        val nm = scan.readLine.split(" ")
        val n = nm(0).trim.toInt
        val m = nm(1).trim.toInt

        val a = scan.readLine.split(" ").map(_.trim.toInt)
        val b = scan.readLine.split(" ").map(_.trim.toInt)
        val total = getTotalX(a, b)

        println(total)
    }
}
