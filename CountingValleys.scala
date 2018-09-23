
object CountingValleys {

    // Complete the countingValleys function below.
    def countingValleys(n: Int, stepsInput: Array[String]): Int = {
        val seaLevel = 0
        var currentLevel = 0
        var switches = 0
        var isInTheValley = false

        val steps: List[Int] = stepsInput.map {
            case "D" => -1
            case "U" => 1
            case _ => throw new Exception("Unknown step!")
        }.toList

        steps.foreach { step =>
            currentLevel += step
            if (currentLevel < seaLevel && isInTheValley == false) {
                isInTheValley = true
            }

            if (isInTheValley == true && currentLevel >= seaLevel) {
                isInTheValley = false
                switches += 1
            }
        }

        switches
    }


    def main(args: Array[String]): Unit = {
        val stdIn = scala.io.StdIn

        val n = stdIn.readLine.trim.toInt
        val stepsInput = stdIn.readLine.trim.split("")

        println(countingValleys(n, stepsInput))
    }
}