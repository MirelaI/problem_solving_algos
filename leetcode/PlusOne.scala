import scala.collection.mutable.ArrayBuffer

object Solution {

    def plusOne(digits: Array[Int]): Array[Int] = {
        val digitsBuffer = digits.to[ArrayBuffer]

        var toAdd = 1
        var reverseIndex = digits.size - 1
        while (toAdd == 1 && reverseIndex >= 0) {
            val x = digits(reverseIndex) + 1
            x match {
                case s: Int if x >= 10 => 
                    digitsBuffer(reverseIndex) = s % 10
                case _ => 
                    digitsBuffer(reverseIndex) = x
                    toAdd = 0
            }

            reverseIndex -= 1
        }

        if (toAdd == 1) {
           (toAdd +: digitsBuffer).toArray
        } else {
            digitsBuffer.toArray
        }
    }

    def main(args: Array[String]): Unit = {
        val array = Array(9,9,9)
        val plusOneArray = plusOne(array)

        plusOneArray.foreach { println _}
    }
}