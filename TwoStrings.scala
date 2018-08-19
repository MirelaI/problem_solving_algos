
object Solution {

    // Complete the twoStrings function below.
    def twoStrings(s1: String, s2: String): Boolean = {
        val s1List = s1.split("")
        val s2Map = s2.split("").map { elem => elem -> 1}.toMap

        s1List.map { elem => 
            s2Map.get(elem).isDefined
        }.exists ( _ == true )
    }

    def main( args: Array[String] ) {
        val stdin = scala.io.StdIn
        val q = stdin.readLine.trim.toInt

        for (qItr <- 1 to q) {
            val s1 = stdin.readLine
            val s2 = stdin.readLine

            val result = twoStrings(s1, s2)

            println(if (result) "YES" else "NO")
        }
    }
}
