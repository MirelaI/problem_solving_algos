
object DesignerPDFViewer {
    private val alphabet = List(
        "a", "b", "c", "d", "e",
        "f", "g", "h", "i", "j",
        "k", "l", "m", "n", "o", 
        "p", "q", "r", "s", "t",
        "u", "v", "w", "x", "y", 
        "z"
    )

    def designerPdfViewer(heights: Array[Int], word: String): Int = {
        val alphabetHeights: Map[String, Int] = alphabet
            .zipWithIndex
            .map { case (letter, index) => 
                letter -> heights(index)
            }
            .toMap
        println(alphabetHeights)
        val wordHeights = word.split("").map { x => alphabetHeights(x) }.max

        wordHeights * word.length
    }


    def main(args: Array[String]): Unit = {
        val stdin = scala.io.StdIn 

        val h = stdin.readLine.split(" ").map(_.trim.toInt)
        val word = stdin.readLine

        val result = designerPdfViewer(h, word)
        println(result)
    }
}