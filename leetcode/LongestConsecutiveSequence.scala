// Input [100, 4, 200, 1, 3, 2]
// Output: 4

import scala.collection.mutable.{ArrayBuffer, Map}

object LongestConsectutiveSequence {

    def longestConsecutive(nums: Array[Int]): Int = {
        if (nums.isEmpty) return 0
        if (nums.size == 1) return 1
        val numsBuffer = nums.to[ArrayBuffer]

        val numsMap: Map[Int, Int] = collection.mutable.Map(nums.map { _ -> 0}.toSeq: _*) 
        findChildren(numsMap, numsBuffer.tail, nums.head, 1)

        numsMap.values.groupBy(identity).mapValues(_.size).values.max
    }

    @scala.annotation.tailrec
    def findChildren(
        numsMap: Map[Int, Int], 
        nums: ArrayBuffer[Int], 
        current: Int, 
        sequenceNo: Int
    ): Unit = {
        // Return if we already visited the node
        if (numsMap(current) != 0) return ()
        
        // Mark the node as visited
        numsMap.update(current, sequenceNo)
        if (nums.size == 0) return ()

        if (numsMap.get(current - 1).isDefined && numsMap(current - 1) == 0) {
            findChildren(numsMap, nums, current - 1, sequenceNo)
        } 
        
        if (numsMap.get(current + 1).isDefined && numsMap(current + 1) == 0) {
            findChildren(numsMap, nums, current + 1, sequenceNo)
        }

        findChildren(numsMap, nums.tail, nums.head, sequenceNo + 1)
    }
}