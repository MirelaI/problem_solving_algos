// Given an array of integers, return indices of the two numbers such that they add up to a specific target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// Example:

// Given nums = [2, 7, 11, 15], target = 9,

// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.HashMap

object Solution {

    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        val indexMap = new HashMap[Int, Int]

        var found = false
        var indices = ArrayBuffer[Int]()

        for (i <- 0 until nums.size) {
            val x = nums(i)
            val complement = target - x 
            if (indexMap.get(complement).isDefined && !found) {
                indices += (i, indexMap(complement))
                found = true
            }

            indexMap += (x -> i)
        }

        indices.size match {
            case 0 => null
            case _ => indices.toArray.sorted
        }
        
    }

    def main(args: Array[String]): Unit = {
        val testArray = Array(3, 2, 3)
        val target = 5

        val result = twoSum(testArray, target)
        result.foreach { println }
    }
}