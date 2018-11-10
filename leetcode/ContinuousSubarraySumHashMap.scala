import scala.collection.mutable.Map

// Given a list of non-negative numbers and a target integer k, write a function to check 
// if the array has a continuous subarray of size at least 2 that sums up to the multiple
// of k, that is, sums up to n*k where n is also an integer.

object Solution {
    def checkSubarraySum(nums: Array[Int], k: Int): Boolean = {
        var sum = 0
        val mapSums = Map[Int, Int]() 
        
        if (k == 0) return (nums.sum == 0 && nums.size > 1)
        
        mapSums(0) = -1
        for (i <- 0 until nums.length) {
            sum += nums(i)
            val v = sum % k
            
            if (mapSums.get(v).isDefined) {
                if ((i - mapSums(v)) > 1) return true
            } else {
                mapSums(v) = i
            }
        }

        false
    
    }
}