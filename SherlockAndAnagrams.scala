/* 
Two strings are anagrams of each other if the letters of one string can be 
rearranged to form the other string. Given a string, find the number of pairs
of substrings of the string that are anagrams of each other.

For example s = mom, the list of all anagrammatic pairs is [m,m], [[m,o],[o,m]] at positions [0,2] and [[0,1], [1,2]]  respectively.
Test case 1:
Input: abcd
Arrays: [a], [b] [c] [d]
Arrays: [ab], [bc] [cd]
Arrays: [abc], [bcd]
Result -> 0
*/

import scala.collection.mutable.{ ArrayBuffer, Map }

object Solution {

    // Complete the sherlockAndAnagrams function below.
    def sherlockAndAnagrams(inputString: String): Int = {
        // Split the input in small strings
        val inputArray: Array[String] = inputString.split("")
        val mapBuffer: Map[String, Int] = Map()
        var size = 1
        for (i <- 0 until inputArray.size) {
            var inputBuffer: ArrayBuffer[String] = ArrayBuffer[String]()
            for (j <- 0 to inputArray.size - size) {
                val subString = inputArray.slice(j, j + size).sorted.mkString("")
                if (mapBuffer.get(subString).isDefined) 
                    mapBuffer(subString) += 1 
                else
                    mapBuffer.update(subString, 1) 
            }
            
            size += 1
        }

        mapBuffer.values
        .filter{ _ > 1 }
        .foldLeft(0){ (a, b) => a + b*(b-1)/2 }
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn
        val q = stdin.readLine.trim.toInt

        for (qItr <- 1 to q) {
            val s = stdin.readLine
            val result = sherlockAndAnagrams(s)

            println(result)
        }
    }
}