// Given a collection of intervals, merge all overlapping intervals.

// Example 1:

// Input: [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// Example 2:

// Input: [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considerred overlapping.

import scala.collection.mutable.Stack
import Math.{max, min}

object Solution {
  def mergeIntervals(intervals: List[List[Int]]): List[List[Int]] = {
    // Implement a stack
    val mergedIntervals = Stack[List[Int]]()

    for (interval <- intervals) {
      // First entry case
      if (mergedIntervals.headOption.isEmpty) {
        mergedIntervals.push(interval)
      } else {
        // [[1,3],[2,6],[8,10],[15,18]]
        if (mergedIntervals.head(1) >= interval(1) && mergedIntervals.head(0) <= interval(0)) {
          // go to the next entry
        } else if (mergedIntervals.head(1) >= interval(0) && mergedIntervals.head(1) <= interval(1)) {
          val headOfStack = mergedIntervals.pop
          val startOfMerged = min(headOfStack(0), interval(0))
          val endOfMerged = max(headOfStack(1), interval(1))

          val mergedInt = List(startOfMerged, endOfMerged)
          mergedIntervals.push(mergedInt)
        } else {
          mergedIntervals.push(interval)
        }
      }
    }

    mergedIntervals.toList.reverse
  }

  def main(args: Array[String]): Unit = {
    val intervals = List(List(1,3), List(2,6), List(8, 10), List(15, 18))
    val mergedIntervals: List[List[Int]] = mergeIntervals(intervals)

    println(mergedIntervals)
  }
}