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

case class Interval(start: Int = 0, end: Int = 0)

object Solution {

  def merge(intervals: List[Interval]): List[Interval] = {
    val intervalsSorted = intervals.sortBy( _.start )
    // Implement a stack
    val mergedIntervals = Stack[Interval]()

    for (interval <- intervalsSorted) {
      // First entry case
      if (mergedIntervals.headOption.isEmpty) {
        mergedIntervals.push(interval)
      } else {
        // [[1,3],[2,6],[8,10],[15,18]]
        if (mergedIntervals.head.end >= interval.end && mergedIntervals.head.start <= interval.start) {
          // go to the next entry
        } else if (
          // [1,4], [0, 1]
          (mergedIntervals.head.end >= interval.start && mergedIntervals.head.end <= interval.end)) {
          val headOfStack = mergedIntervals.pop
          val startOfMerged = min(headOfStack.start, interval.start)
          val endOfMerged = max(headOfStack.end, interval.end)

          val mergedInt = Interval(startOfMerged, endOfMerged)
          mergedIntervals.push(mergedInt)
        } else {
          mergedIntervals.push(interval)
        }
      }
    }

    mergedIntervals.toList.reverse
  }

  def main(args: Array[String]): Unit = {
    val intervals = List(Interval(1,4), Interval(0,1))
    val mergedIntervals: List[Interval] = merge(intervals)

    println(mergedIntervals)
  }
}