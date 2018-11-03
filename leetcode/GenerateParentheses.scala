import scala.collection.mutable.ArrayBuffer

object Solution {

    def generateParenthesis(n: Int): List[String] = {
        val res = new ArrayBuffer[String]()

        // We start with recursiveness and pass an empty string ""
        dfs(res, "", n, 0)

        res.toList
    }

    def dfs(res: ArrayBuffer[String], s: String, n: Int, count: Int): Unit = {
        if (n < 0 || count < 0) {
            return ()
        }

        if (n == 0 && count == 0) {
            res += s
        }

        // Depth frist search
        dfs(res, s + "(", n - 1, count + 1);
        dfs(res, s + ")", n, count - 1);
    }

    def main(args: Array[String]): Unit = {
        val generatedList = generateParenthesis(3)

        println(generatedList)       
    }
}
