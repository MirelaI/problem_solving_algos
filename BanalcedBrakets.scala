import scala.io.StdIn
import scala.collection.mutable.Stack

object Solution {
    val openCloseBracketsMatches = Map(
        "(" -> ")",
        "[" -> "]",
        "{" -> "}"
    )

    def isBracketsListBalanced(brackets: List[String]): Boolean = {
        brackets.size match {
            // Assumption taken that the array is empty so is nothing to
            // evaluate. Probably best to throw an error.
            case 0 => throw new Exception("No brackets string defined")
            // Odd number of elements in the list
            case n: Int if n % 2 == 1 => false
            case _ => {
                val openBrackets = new Stack[String]()
                // Make the assumption that the list is balanced
                var isBalanced = true
                for ( bracket <- brackets ) {
                    // if is an open bracket
                    if (openCloseBracketsMatches.get(bracket).isDefined) {
                        openBrackets.push(bracket)
                    }
                    // if is a close bracket
                    else {
                        val openBracket = openBrackets.pop
                        if (openCloseBracketsMatches(openBracket) != bracket ) {
                            isBalanced = false
                        }
                    }

                }
                isBalanced
            }
        }
    }

    def main(args: Array[String]) {
        val stdin = StdIn
        val inputString: String = stdin.readLine.trim().stripLineEnd

        val isBalanced = isBracketsListBalanced(inputString.split("").toList)

        println(s"Are the brackets balanced? $isBalanced")
    }
}