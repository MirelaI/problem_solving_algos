/**
* Definition for an interval.
* class Interval(var _start: Int = 0, var _end: Int = 0) {
*   var start: Int = _start
*   var end: Int = _end
* }
*/

// Given an array of meeting time intervals consisting of start and end times 
// [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference 
// rooms required.

case class Interval(start: Int = 0, end: Int = 0)

object Solution {
    def minMeetingRooms(intervals: Array[Interval]): Int = {
        val startTimes = intervals.map { _.start }.sorted
        val endTimes = intervals.map { _.end }.sorted

        var meetingRooms = 0
        var endPointer = 0

        for ( i <- 0 until startTimes.size ) {
            if (startTimes(i) < endTimes(endPointer)) {
                meetingRooms += 1
            } else {
                endPointer +=1
            }
        }

        meetingRooms
    }

    def main(args: Array[String]): Unit = {
        // [[2,11],[6,16],[11,16]]
        val meetings = Array(Interval(2, 11), Interval(6, 16), Interval(11,16))
        val meetingRooms = minMeetingRooms(meetings)

        println(meetingRooms)
    } 
}