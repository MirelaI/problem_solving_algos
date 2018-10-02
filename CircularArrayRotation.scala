
/* 
Solution is good, works within the expected time. Since it gives a runtime
error in Scala, I solve it in Perl using the same algorithm and it works 
perfectly, below is a snippet of the perl code: 
for (1..$q) {
    my $queries_item = <>;
    $queries_item =~ s/\s+$//;
    my $index = ($n + ($queries_item % $n) - $k) % $n;
    say $a[$index];
}
where n is the length of the array and k is the number of rotations.
*/

object CircularArrayRotation {

    def circularArrayRotation(array: Array[Int], rotations: Int, queries: Array[Int]): Array[Int] = {  
        val size = array.size 
      
        for ( k <- queries ) yield { 
            val index = (size + (k % size) - rotations) % size
            array(index) 
        }
    }

    def main(args: Array[String]): Unit = {
        val stdin = scala.io.StdIn

        val nkq = stdin.readLine.split(" ")

        val n = nkq(0).trim.toInt
        val k = nkq(1).trim.toInt
        val q = nkq(2).trim.toInt

        val a = stdin.readLine.split(" ").map(_.trim.toInt)

        val queries = Array.ofDim[Int](q)

        for (i <- 0 until q) {
            val queriesItem = stdin.readLine.trim.toInt
            queries(i) = queriesItem
        }

        val result = circularArrayRotation(a, k, queries)

        println(result.mkString("\n"))
    }
}