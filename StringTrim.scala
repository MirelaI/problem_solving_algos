import scala.collection.mutable.ArrayBuffer

/*
Given a string, 'aaabbbcccc', alter the string so that the output
string does not contain more than x same consecutive letters.
Example: 
string: 'aaabbbcccc'
quota: 2
result: aabbcc
*/

object StringTrim {

    def trimStr(inputString: String, quota: Int): String = {
        val inputArray = inputString.split("")
        val tempArray: ArrayBuffer[String] = ArrayBuffer() 
        // Straight forward return conditions
        if (inputArray.size == 0) return inputString
        if (quota > inputArray.size) return inputString
        if (quota == 0) return ""

        var letterQuota = 0
        var previousLetter: Option[String] = None

        for (letter <- inputArray) {
            previousLetter match {
                case None => 
                    tempArray += letter
                    letterQuota += 1 
                case Some(prev) if (prev == letter && letterQuota < quota) => 
                    tempArray += letter

                    letterQuota += 1 
                case Some(prev) if (prev != letter) =>
                    tempArray += letter
                    letterQuota = 1

                case _ => // do nothing
            }

            previousLetter = Some(letter)
        }

        tempArray.mkString("")
    }

    def main(args: Array[String]): Unit = {
        val stdIn = scala.io.StdIn
        val quota = stdIn.readLine.trim.toInt
        val inputString = stdIn.readLine.trim
        
        val trimmedString = trimStr(inputString, quota)

        println(trimmedString)
    }
}