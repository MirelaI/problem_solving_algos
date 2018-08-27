import scala.io.Source
/*
SYNOPSIS:
scala CountWords [filename] [word]

Example:
scala CountWords count_words.txt file
*/

object CountWords {

    def countWord(filename: String, word: String): Int = {
        val fileContent = Source.fromFile(filename).getLines.toList

        fileContent.map { line: String => 
            line.split(" ").filter { _ == word }.size 
        }.sum
    }

    def main(args: Array[String]): Unit = {
        val filename = args(0).trim
        val word = args(1).trim

        val noOfOccurences = countWord(filename,word)

        println(noOfOccurences)
    }
}