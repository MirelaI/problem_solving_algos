import java.io
import Math.abs

object Kangaroo {

    // Complete the kangaroo function below.
    def kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): Boolean = {
        if (x1 > x2 && v1 >= v2) false
        else if (x1 < x2 && v1 <= v2) false
        else {
            
            val areFixJumpes: Boolean = (abs(x1 - x2) % abs(v1 - v2)) == 0

            areFixJumpes
        }
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn
        val x1V1X2V2 = stdin.readLine.split(" ")

        val x1 = x1V1X2V2(0).trim.toInt
        val v1 = x1V1X2V2(1).trim.toInt

        val x2 = x1V1X2V2(2).trim.toInt
        val v2 = x1V1X2V2(3).trim.toInt

        val result = kangaroo(x1, v1, x2, v2)
        println(result)
    }
}
