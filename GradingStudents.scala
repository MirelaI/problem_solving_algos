import java.io.PrintWriter

object GradingStudents {

    /*
     * Complete the gradingStudents function below.
     */
    def gradingStudents(grades: Array[Int]): Array[Int] = {
        grades.map { 
            case grade: Int if grade < 38 => grade
            case grade: Int => 
                val reminder = 5 - grade % 5
                if (reminder < 3 ) grade + reminder
                else grade
        }
    }

    def main(args: Array[String]) {
        val scan = scala.io.StdIn
        val n = scan.readLine.trim.toInt

        val grades = Array.ofDim[Int](n)

        for (gradesItr <- 0 until n) {
            val gradesItem = scan.readLine.trim.toInt
            grades(gradesItr) = gradesItem
        }

        val result = gradingStudents(grades)
        result.foreach { println(_)}
    }
}