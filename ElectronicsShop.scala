object ElectronicsShop {
  
    def getMoneySpent(
        keyboards: Array[Int], 
        drives: Array[Int], 
        money: Int 
    ): Int = {
        val keyboardsSorted = keyboards.sorted
        val drivesSorted = drives.sorted
        var max = 0

        if (keyboardsSorted(0) + drivesSorted(0) > money) {
            -1 
        } else {
            for (keyboard <- keyboardsSorted) {
                for (driver <- drivesSorted) {
                    val totalSum = keyboard + driver
                    if ( totalSum <= money && totalSum > max) {
                        max = totalSum
                    }
                }
            }

            max
        }
    }

    def main(args: Array[String]): Unit = {
        val stdIn = scala.io.StdIn 

        val bnm = stdIn.readLine.split(" ")

        val b = bnm(0).trim.toInt

        val n = bnm(1).trim.toInt

        val m = bnm(2).trim.toInt

        val keyboards = stdIn.readLine.split(" ").map(_.trim.toInt)

        val drives = stdIn.readLine.split(" ").map(_.trim.toInt)
        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        val moneySpent = getMoneySpent(keyboards, drives, b)

        println(moneySpent)
    }
}