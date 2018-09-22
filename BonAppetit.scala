
object BonAppetit {
    def bonAppetit(bill: Array[Int], indexOfItemNotOrdered: Int, charged: Int): Int = {
        charged - (bill.sum - bill(indexOfItemNotOrdered))/2
    }

    def main(args: Array[String]): Unit = {
        val stdIn = scala.io.StdIn
        val nk = stdIn.readLine.replaceAll("\\s+$", "").split(" ")

        val totalItems = nk(0).toInt

        val itemNotOrdered = nk(1).toInt

        val bill = stdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
        val charged = stdIn.readLine.trim.toInt

        val fairCharge = bonAppetit(bill, itemNotOrdered, charged)

        fairCharge match {
            case reminder if reminder > 0 => println(reminder)
            case _ => println("Bon Appetit")
        }
    }
}