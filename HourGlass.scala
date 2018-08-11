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

    // Complete the hourglassSum function below.
    def hourglassSum(arr: Array[Array[Int]]): Int = {
        val listOfSums: ArrayBuffer[Option[Int]] = new ArrayBuffer()
        for (i <- 0 to arr.size) {
            for (j <- 0 to arr.size) {
                val hourGlassSum = readHourGlass(i, j, arr)
                
                listOfSums += hourGlassSum
            } 
        }

        listOfSums.flatten.max
    }

    def readHourGlass(i: Int, j: Int, arr: Array[Array[Int]]): Option[Int] = {
        if ( i * 2 > arr.size || j * 2 > arr.size ) { 
            None
        } else {
            val currentHourGlass: ArrayBuffer[Int] = new ArrayBuffer()
            val endI: Int = i + 2
            val endJ: Int = j + 2

            for (ii <- i to endI) {
                for (jj <- j to endJ) {
                    if (!(ii == i+1 && (jj == j || jj == j + 2))) {
                        currentHourGlass += arr(ii)(jj)
                    }
                }
            } 

            Some(currentHourGlass.sum)
        }        
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn
        val arr = Array.ofDim[Int](6, 6)

        for (i <- 0 until 6) {
            arr(i) = stdin.readLine.split(" ").map(_.trim.toInt)
        }

        val result = hourglassSum(arr)

        println(result)
    }
}
