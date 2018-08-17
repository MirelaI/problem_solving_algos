import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.mutable.ArrayBuffer

object Solution {

    // Complete the arrayManipulation function below.
    def arrayManipulation(n: Int, queries: Array[Array[Int]]): Long = {
        val arrayBuffer: ArrayBuffer[Long] = ArrayBuffer.fill(n)(0L)

        for ( query <- queries ) {
            val startIndex = query(0) 
            val endIndex = query(1)
            val valueToAdd = query(2)

            arrayBuffer(startIndex) += valueToAdd
            if (endIndex+1 <= arrayBuffer.size) arrayBuffer(endIndex) -= valueToAdd
            println(arrayBuffer.toString)
        }

        var max: Long = 0 
        var temp: Long = 0 

        for (x <- arrayBuffer) {
            temp = temp + x.toLong
            if (max < temp) max = temp 
        }

        max
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn
        val nm = stdin.readLine.split(" ")
        val n = nm(0).trim.toInt
        val m = nm(1).trim.toInt

        val queries = Array.ofDim[Int](m, 3)

        for (i <- 0 until m) {
            queries(i) = stdin.readLine.split(" ").map(_.trim.toInt)
        }

        val result = arrayManipulation(n, queries)
        println(s"Max of elements: $result")
    }
}
