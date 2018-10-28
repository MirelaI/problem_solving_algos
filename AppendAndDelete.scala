
object Solution {

    // Complete the appendAndDelete function below.
    def appendAndDelete(s: String, t: String, k: Int): Boolean = {
        val sArray = s.split("")
        val tArray = t.split("")
        var foundIndex = false
        var matches = (0 until s.length).foldLeft(0) { (s, index) => 
            index match {
                case i  if (i < t.length && sArray(i) == tArray(i) && !foundIndex) => 
                    s + 1
                case i  if (index < t.length && sArray(i) != tArray(index) && !foundIndex) => 
                    foundIndex = true
                    s 
                case _ => s
            }
        }

        val difference = (s.size - matches)
        val remainingCost = k - difference 
        
        // Feels soo hacked as there are so many cases :|
        remainingCost match {
            case x if x > t.size => true
            case x if x < (t.size - matches) => false
            case x if x == k => true
            case y if y % 2 == 0 => true
            case 0 => true
            case _ => false
        }
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val s = stdin.readLine
        val t = stdin.readLine
        val k = stdin.readLine.trim.toInt

        val result = appendAndDelete(s, t, k)

        println( if (result) "Yes" else "No")
    }
}
