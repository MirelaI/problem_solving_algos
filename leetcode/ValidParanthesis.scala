

object Solution {

    def isValid(string: String): Boolean = {
        val defaults = Map(
            "(" -> ")",
            "[" -> "]",
            "{" -> "}"
        )

        val arrayOfParenthesis = string.split("")


        string.length match {
            case 0 => true
            // Odd number of elements in the list
            case s: Int if s % 2 != 0 => false 
            case _ => 
                // We start with the assumption that the paranthesis are balanced
                var isBalanced = true

                // Use a stack to keep track of all the opening brackets
                var stack = List[String]()
                for (p <- arrayOfParenthesis) {
                    if (defaults.get(p).isDefined) {
                        // Open bracket case
                        stack = p :: stack
                    } else {
                        // Close bracket case
                        // At this point we do not know if we have something in our stack,
                        // so it's save to use headOption
                        val openComplement = stack.headOption
                        if (openComplement.isDefined && defaults(openComplement.head) == p) {
                            stack = stack.drop(1)
                        } else {
                            isBalanced = false
                        }
                    }
                }

                isBalanced && stack.isEmpty
        }
    }

    def main(args: Array[String]): Unit = {
        val string = "(("
        println(isValid(string))
    }
}