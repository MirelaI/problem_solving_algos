object ClimbingTheLeaderboard {

    // Complete the climbingLeaderboard function below.
    def climbingLeaderboard(scores: Array[Int], aliceScores: Array[Int]): Array[Int] = {
        val uniqueScores = scores.distinct
        var lastIndex = uniqueScores.size 

        aliceScores.map { score: Int => 
            val valueToCompare: Int = binarySearch(uniqueScores.take(lastIndex), score)
            val rank = uniqueScores.indexOf(valueToCompare) + 1
            lastIndex = rank

            score match {
                case x: Int if x < valueToCompare => rank + 1
                case x: Int if x > valueToCompare => 
                    if (rank - 1 > 0) rank - 1 else rank
                case _ => rank
            }
        }

    }

    def binarySearch(scores: Array[Int], score: Int): Int = {
        scores.size match {
            // Scores = 100 90 90 80 75 60
            case 1 => scores(0)
            case _ => 
                val mid = scores.size/2 

                if (scores(mid) > score) {
                    binarySearch(scores.drop(mid), score)
                } else {
                    binarySearch(scores.take(mid), score)
                }
        }
    }


    def main(args: Array[String]): Unit = {        
        val stdin = scala.io.StdIn

        val scoresCount = stdin.readLine.trim.toInt

        val scores = stdin.readLine.split(" ").map(_.trim.toInt)
        scores.foreach(println(_))
        val aliceCount = stdin.readLine.trim.toInt

        val alice = stdin.readLine.split(" ").map(_.trim.toInt)
        val result = climbingLeaderboard(scores, alice)

        println(result.mkString("\n"))
    }
}