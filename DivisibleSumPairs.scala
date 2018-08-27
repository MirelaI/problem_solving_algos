/*
Problem statement
-----------------
You are given an array of n integers, ar = [ar[0], ar[1],...ar[n-1]], and a positive integer, k.
Find and print the number of (i, j) pairs where i < j and a[i] + a[j] is divisible by k.

For example, ar = [1, 2, 3, 4, 5, 6] and k = 5. 
Our three pairs meeting the criteria are [1, 4], [2, 3], and [4, 6].
*/
object Solution {
    // How to approach the problem:
    // Brute force: iterate through the list of elements
    // For each element find the corespondent in the input
    // list that added to the element will be divisible with
    // Complexity -> O(n^2) :/ 
    // the `divider`
    // Assumptions: 
    // - elements are not unique
    // - the list in not sorted

    def divisibleSumPairs(divider: Int, inputArray: Array[Int]): Option[Int] = {
        if (inputArray.isEmpty) return Some(0)
        if (divider == 0 ) return None
        val totalPairs = (0 until inputArray.size).map { index: Int =>
            val elem = inputArray(index)
            val corespondents = (index+1 until inputArray.size).filter { tempIndex: Int =>
                val tempElem = inputArray(tempIndex)
                (elem + tempElem) % divider == 0
            }
            corespondents.size
        }

        Some(totalPairs.sum)
    }

    def main(args: Array[String]): Unit = {
        val stdin = scala.io.StdIn
        
        val nk = stdin.readLine.split(" ")
        val n = nk(0).trim.toInt
        val k = nk(1).trim.toInt

        val ar = stdin.readLine.split(" ").map(_.trim.toInt)
        val result = divisibleSumPairs(k, ar)

        println(result)
    }
}