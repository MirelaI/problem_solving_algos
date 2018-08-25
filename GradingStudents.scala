import java.io.PrintWriter

/*
Sam is a professor at the university and likes to round each student's  according to these rules:

If the difference between the grade and the next multiple of 5 is less than 3, round grade up to the next multiple of 5.
If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade.
*/

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