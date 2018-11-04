// Input [100, 4, 200, 1, 3, 2]
// Output: 4

object LongestConsectutiveSequence {

    def longestConsecutive(nums: Array[Int]): Int = {
        val numsMap: Map[Int, Boolean] = nums.map { _ -> true}.toMap
        var longestSeq = 0

        for (num <- nums) {
            val previous = num - 1

            if (numsMap.get(previous).isEmpty) {
                var current = num + 1 
                var currentSeq = 1

                while (numsMap.get(current).isDefined) {
                    currentSeq += 1
                    current += 1
                }

                if (currentSeq > longestSeq) longestSeq = currentSeq
            } 

        }

        longestSeq
    }

    def main(args: Array[String]): Unit = {
        val digits = Array(100,4,200,1,3,2)

        println(longestConsecutive(digits))
    }
}