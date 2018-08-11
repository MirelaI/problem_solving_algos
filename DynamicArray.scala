import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.immutable._
import scala.collection.mutable._
import scala.collection.concurrent._
import scala.collection.parallel.immutable._
import scala.collection.parallel.mutable._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._

object Solution {

    // Complete the dynamicArray function below.
    def dynamicArray(n: Int, queries: Array[Array[Int]]): Array[Int] = {
        var sequence: Array[ArrayBuffer[Int]] = (for (i <- 0 to n) yield ArrayBuffer[Int]()).toArray
        var lastAnswer: Int = 0
        val result: ArrayBuffer[Int] = ArrayBuffer[Int]()

        for (query <- queries) {
            val x = query(1)
            val y = query(2)
            val index = (x ^ lastAnswer) % n

            if (query(0) == 1) {
                sequence(index) += y
            } 

            if (query(0) == 2) {
                val innerIndex = y % sequence(index).size
                lastAnswer = sequence(index)(innerIndex)
                result += lastAnswer
            }
        }
        result.toArray
    }

    def main(args: Array[String]) {
        val nq = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

        val n = nq(0).toInt

        val q = nq(1).toInt

        val queries = Array.ofDim[Int](q, 3)

        for (i <- 0 until q) {
            queries(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
        }

        dynamicArray(n, queries)
    }
}
