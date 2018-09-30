
object AngryPrefessor {

    def angryProfessor(threshold: Int, times: Array[Int]): Boolean = {
        times.filter {_ <= 0}.size < threshold 
    }
    
    def main(args: Array[String]): Unit = { 
        val stdin = scala.io.StdIn 
        val t = stdin.readLine.trim.toInt

        for (tItr <- 1 to t) {
            val nk = stdin.readLine.split(" ")
            val n = nk(0).trim.toInt
            val k = nk(1).trim.toInt

            val a = stdin.readLine.split(" ").map(_.trim.toInt)
            val result = angryProfessor(k, a)

            println(if(result) "YES" else "NO")
        }
    }
}