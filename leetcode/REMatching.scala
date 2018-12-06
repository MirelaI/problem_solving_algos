// Input: t -> aaabbbfgd , p -> aaa...fgd
//
//
//
object Solution {

  def isAMatch(text: String, pattern: String): Boolean = {

    if (pattern.isEmpty) return text.isEmpty
    val theyMatch = (text.nonEmpty && List(text.head + "", ".").contains(pattern.head + ""))

    if (pattern.size >= 2 && pattern(1).toString == "*") {
      isAMatch(text, pattern.drop(2)) || (theyMatch && isAMatch(text.tail, pattern))
    } else  {
      theyMatch && isAMatch(text.tail, pattern.tail)
    }
  }

  def main(args: Array[String]): Unit {

  }
}