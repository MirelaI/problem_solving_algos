import scala.collection.mutable.Map
object Solution {

    def migratoryBirds(birds: Array[Int]): Int = {
        val birdsMap = (1 to 5).map { birdNo =>
            birdNo -> birds.count( _ == birdNo )
        }.toSeq.sortWith ( _._2 > _._2).head._1
    }


    def main(args: Array[String]) {
        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val arrCount = StdIn.readLine.trim.toInt

        val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
        val result = migratoryBirds(arr)

        printWriter.println(result)

        printWriter.close()
    }
}