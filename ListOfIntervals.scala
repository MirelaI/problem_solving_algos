
import scala.collection.mutable.ArrayBuffer

/*
Given a list of intervals, insert a new interval in the
provided list.
Example:
List of intervals:
[1, 2], [5, 9], [12, 20] : [4, 5] => [1, 2], [4, 9], [12, 20]
[1, 2], [5, 9], [12, 20] : [3, 4] => [1, 2], [3, 4], [5, 9], [12, 20]
[1, 2], [5, 9], [12, 20] : [0, 21] => [0, 21]
*/
// My thinking through the problem
// 1 5 12 => 1 4 5 12
// 2 9 20 => 2 5 9 20

// => 1 2, 4 5 5 9, 12, 20

// 1 5 12 => 1, 3, 5, 12
// 2 9 20 => 2, 4, 9, 20

// => 1,2 3,4 5,9 12,20

// 1 5 12 => 0, 1, 5, 12
// 2 9 20 => 2, 9, 20, 21

// => 0,2, 1,9, 5, 20, 12, 21 => 0, 21

object ListOfIntervals {

    def insertInterval(listOfIntervals: List[List[Int]], interval: List[Int]): List[List[Int]] = {
        val starts = listOfIntervals.map { case el => el(0) }
        val ends = listOfIntervals.map { case el => el(1) }

        val newStarts = (interval(0) :: starts).sorted // O(n log n)
        val newEnds = (interval(1) :: ends).sorted // O(n log n)

        val list = (0 until newStarts.size).map { case i => List(newStarts(i), newEnds(i))} // O(n)
        val mergedIntervals = mergeIntervals(list.toList) // O(n ^ 2)

        mergedIntervals.toList
    }

    def mergeIntervals(list: List[List[Int]]): List[List[Int]] = {
        for ( i <- 0 until list.size - 1) {
            val currentElem = list(i)
            val nextElem = list(i+1)
            if ( currentElem(1) >= nextElem(0) && currentElem(1) <= nextElem(1)) {
                val newElem = List(currentElem(0), nextElem(1))
                val newList = list.take(i) ++ List(newElem) ++ list.drop(i+2)

                return mergeIntervals(newList)
            }
        }

        list
    }

    def main(args: Array[String]): Unit = {
        val listOfIntervals = List(List(1, 2), List(5, 9), List(12,20))
        // Writting tests ... kind of
        val intevalToInsert = List(0, 1)
        val inservals = insertInterval(listOfIntervals, intevalToInsert)
        val isAsExpected = if (inservals == List(List(0, 2), List(5, 9), List(12, 20))) true else false
        println(isAsExpected)

        val intevalToInsert1 = List(3, 4)
        val inservals1 = insertInterval(listOfIntervals, intevalToInsert1)
        val isAsExpected1 = if (inservals1 == List(List(1, 2), List(3, 4), List(5, 9), List(12, 20))) true else false
        println(isAsExpected1)

        val intevalToInsert2 = List(1, 20)
        val inservals2 = insertInterval(listOfIntervals, intevalToInsert2)
        val isAsExpected2 = if (inservals2 == List(List(1, 20))) true else false
        println(isAsExpected2)

        val intevalToInsert3 = List(21, 22)
        val inservals3 = insertInterval(listOfIntervals, intevalToInsert3)
        val isAsExpected3 = if (inservals3 == List(List(1, 2), List(5, 9), List(12, 20), List(21, 22))) true else false
        println(isAsExpected3)
    }
}