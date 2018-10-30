// This solution is not the best. We need to use dynamic programming
// to make it performant

object Solution {
    def isMatch(text: String, pattern: String): Boolean = {
        // Add the return condition
        if (pattern.isEmpty) return text.isEmpty 

        val firstMatch: Boolean = text.nonEmpty && 
            List(text.head, ".".head).contains(pattern.head)

        if (pattern.size >= 2 && pattern(1) == "*".head) {
            isMatch(text, pattern.drop(2)) || (firstMatch && isMatch(text.tail, pattern)) 
        } else { 
            firstMatch && isMatch(text.tail, pattern.tail)
        }

    }

    def main(args: Array[String]): Unit = {
        val s = "aaabbcc"
        val p = "a.*bbc."
        println(isMatch(s, p))
    }
}