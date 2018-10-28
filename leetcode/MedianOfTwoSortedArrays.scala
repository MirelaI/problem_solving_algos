object Solution {
    def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
        val finalArray = (nums1 ++ nums2).sorted
        val mid = finalArray.size / 2  
        
        finalArray.size match {
            case s: Int if s % 2 == 0 => 
                val x = (finalArray(mid - 1) + finalArray(mid)) / 2.0
                x
            case _ => finalArray(mid)
        }
    }

    def main(args: Array[String]): Unit = {
        val leftArray = Array(1, 2)
        val rightArray = Array(3, 4)
        
        println(findMedianSortedArrays(leftArray, rightArray))
    }
}