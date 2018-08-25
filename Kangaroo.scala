import java.io
import Math.abs

/*
You are choreographing a circus show with various animals. For one act, you are
given two kangaroos on a number line ready to jump in the positive direction 
(i.e, toward positive infinity).

The first kangaroo starts at location x1 and moves at a rate of v1 meters per jump.
The second kangaroo starts at location x2 and moves at a rate of v2 meters per jump.
You have to figure out a way to get both kangaroos at the same location at the 
same time as part of the show. If it is possible, return YES, otherwise return NO.

Example: For example, kangaroo 1 starts at x1 = 2 with a jump distance v1 = 1 and
kangaroo 2 starts at x2 = 1 with a jump distance of v2 = 2. After one jump, they
are both at x = 3, ( x1 + v1 = 2 + 1, x2 + v2 = 1 + 2), so our answer is YES.
*/
object Kangaroo {

    // Complete the kangaroo function below.
    def kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): Boolean = {
        if (x1 > x2 && v1 >= v2) false
        else if (x1 < x2 && v1 <= v2) false
        else (abs(x1 - x2) % abs(v1 - v2)) == 0
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
