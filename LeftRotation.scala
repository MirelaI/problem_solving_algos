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

    def rotateArray(d: Int, inputArray: Array[Int]) = {
        val arrayBuffer = inputArray.to[ArrayBuffer]
        
        for ( i <- 0 until d ) {
            val removedElement = arrayBuffer.remove(0)
            arrayBuffer += removedElement
        }
        
        arrayBuffer.toArray
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val nd = stdin.readLine.split(" ")

        val n = nd(0).trim.toInt

        val d = nd(1).trim.toInt

        val inputArray = stdin.readLine.split(" ").map(_.trim.toInt)
        
        val rotatedArray = rotateArray(d, inputArray)
        println(rotatedArray.mkString(" "))

    }
}