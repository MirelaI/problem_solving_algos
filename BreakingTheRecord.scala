import scala.collection.mutable.ArrayBuffer
/*
Maria plays college basketball and wants to go pro. Each season she maintains
a record of her play. She tabulates the number of times she breaks her season
record for most points and least points in a game. Points scored in the first
game establish her record for the season, and she begins counting from there.

For example, assume her scores for the season are represented in the array 
scores = [12, 24, 10 ,24]. Scores are in the same order as the games played.

Given Maria's scores for a season, find and print the number of times she
breaks her records for most and least points scored during the season.
*/

object Solution {

    // Complete the breakingRecords function below.
    // Non-functional at it's BEST! :o
    def breakingRecords(scores: Array[Int]): Array[Int] = {
        var min = scores(0) 
        var max = scores(0)
        var records = ArrayBuffer(0,0)
        
        for (score <- scores) {
            score match {
                case newMin: Int if score < min => 
                    min = newMin
                    records(1) += 1 
                case newMax: Int if score > max => 
                    max = newMax
                    records(0) += 1
                case _ =>  
            }
        }

        records.toArray
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val n = stdin.readLine.trim.toInt

        val scores = stdin.readLine.split(" ").map(_.trim.toInt)
        val result = breakingRecords(scores)

        println(result.mkString(" "))
    }
}