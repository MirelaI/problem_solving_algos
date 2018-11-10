import scala.collection.mutable.ArrayBuffer

object Solution {
    def checkSubarraySum(nums: Array[Int], k: Int): Boolean = {
        var exists = false
        
        if (k == 0) return (nums.sum == 0 && nums.size > 1)
 
        for (num <- nums) {
            val subarray = ArrayBuffer[Int](num)
            var previous = num
            
            while (!exists) {
                if (subarray.sum % k == 0 && subarray.size > 1) {
                    exists = true
                } else {
                    val currentIndex = nums.indexOf(previous) + 1
                    if (currentIndex < nums.size) {
                        val currentElem = nums(currentIndex)
                        previous = currentElem
                        subarray += currentElem                
                    }
                }
            }
        }
        
        exists
    }
}