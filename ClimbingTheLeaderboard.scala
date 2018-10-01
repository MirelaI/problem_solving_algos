import scala.collection.mutable.{ArrayBuffer, Queue}

object ClimbingTheLeaderboard {

    // Complete the climbingLeaderboard function below.
    // Assumptions made: 
    // - Alice scores are not sorted in an ascending order so we are going to sort them
    // - Scores are ordered in a descending order
    // Result: no timeouts in Hackerrank and all tests pass!
    def climbingLeaderboard(scores: Array[Int], aliceScores: Array[Int]): Array[Int] = {
        val uniqueScores = scores.distinct
        val aliceScoresQueue = aliceScores.sorted.to[Queue]
        val startIndex = uniqueScores.size - 1
        val ranks = new ArrayBuffer[Int]()

        // Go descending...we know the unique scores are in descending order
        for (i <- startIndex to (0, -1)) {
            if (aliceScoresQueue.nonEmpty) {
                while (aliceScoresQueue.nonEmpty && aliceScoresQueue.head < uniqueScores(i)) {
                    ranks += i + 2
                    aliceScoresQueue.dequeue
                }

                while (aliceScoresQueue.nonEmpty && aliceScoresQueue.head == uniqueScores(i)) {
                    ranks += i + 1
                    aliceScoresQueue.dequeue
                }
            }
        }

        ranks.toArray ++ Array.fill(aliceScoresQueue.size)(1)
    }

    def main(args: Array[String]): Unit = {        
        val stdin = scala.io.StdIn

        val scoresCount = stdin.readLine.trim.toInt

        val scores = stdin.readLine.split(" ").map(_.trim.toInt)
        val aliceCount = stdin.readLine.trim.toInt

        val alice = stdin.readLine.split(" ").map(_.trim.toInt)
        val result = climbingLeaderboard(scores, alice)

        println(result.mkString("\n"))
    }
}