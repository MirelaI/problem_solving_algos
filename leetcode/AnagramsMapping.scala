object Solution {
    // A = [12, 28, 46, 32, 50]
    // B = [50, 12, 32, 46, 28]
    // We should return: 
    // [1, 4, 3, 2, 0]

    def anagramMappings(left: Array[Int], right: Array[Int]): Array[Int] = {
        left.map { right.indexOf }
    }

    def main(args: Array[String]): Unit = {
        val mappings = anagramMappings(Array(12, 28, 46, 32, 50), Array(50, 12, 32, 46, 28))
        mappings.foreach{ println }
    }
}