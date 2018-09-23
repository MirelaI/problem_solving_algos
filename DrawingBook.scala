
object DrawingBook {

    def pageCount(totalPages: Int, page: Int): Int = {
        val fromBeggining = page / 2

        val toAdd = if (totalPages % 2 == 0) 1 else 0
        val fromEnd = (totalPages + toAdd - page) / 2

        min(fromBeggining, fromEnd)
    }

    def min(a: Int, b: Int): Int = if (a < b) a else b

    def main(args: Array[String]): Unit = {
        val stdIn = scala.io.StdIn

        val totalPages = stdIn.readLine.trim.toInt
        val page = stdIn.readLine.trim.toInt

        val result = pageCount(totalPages, page)
        println(result)
    }
}