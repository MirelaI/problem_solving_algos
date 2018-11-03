
import scala.collection.mutable.ArrayBuffer

object Solution {

    final val digitLetters: Map[Int, List[String]] = Map(
        2 -> List("a", "b", "c"),
        3 -> List("d", "e", "f"),
        4 -> List("g", "h", "i"),
        5 -> List("j", "k", "l"),
        6 -> List("m", "n", "o"),
        7 -> List("p", "q", "r", "s"),
        8 -> List("t", "u", "v"),
        9 -> List("w", "x", "y", "z")
    ) 

    def letterCombinations(digits: String): List[String] = {
        if (digits.isEmpty) return Nil

        val digitList = digits.split("").toList.map { _.toInt }
        var array = new ArrayBuffer[String]()
        var i = 0 

        while (i < digits.size) {
            if (array.isEmpty) {
                val digit = digitList(i)

                array = digitLetters(digitList(i)).to[ArrayBuffer]
            } else {
                val temp = new ArrayBuffer[String]()
                for (s <- array) {
                    for (c <- digitLetters(digitList(i))) {
                        temp += s + c
                    }
                    println(temp)
                }
                array = temp
            }

            i += 1
        } 

        return array.toList       
  } 

  def main(args: Array[String]): Unit = {
      println(letterCombinations("234"))
  }
}