
object ExtraLongFactorials {

    def extraLongFactorials(n: Int): BigInt = {
        // Folding left on a range from 1 to n
        // Product starts from bigInt of 1 and at each
        // iteration I am multiplying by the current element
        (1 to n)./: (BigInt(1)){ _ * BigInt(_) }
    }

    def main(args: Array[String]): Unit = {
        val stdin = scala.io.StdIn

        val n = stdin.readLine.trim.toInt

        val result = extraLondFactorials(n)
        println(result)
    }
}