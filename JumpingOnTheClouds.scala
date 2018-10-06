object JumpingOnTheClouds {

    def jumpingOnClouds(clouds: Array[Int], k: Int): Int = {
        val lcmOfKandArray = lcm(clouds.size, k)
        println(lcmOfKandArray)

        (0 until (lcmOfKandArray, k)).foldLeft(100) { (finalEnergy, index) => 
            if (clouds(index % clouds.size) == 0) finalEnergy - 1 else finalEnergy - 2
        }
    }

    def gcd(a: Int, b: Int):Int = if (b==0) a.abs else gcd(b, a%b)
    def lcm(a: Int, b: Int) = (a*b).abs/gcd(a,b)

    def main(args: Array[String]): Unit = {
        val stdin = scala.io.StdIn

        val nk = stdin.readLine.split(" ")

        val n = nk(0).trim.toInt

        val k = nk(1).trim.toInt

        val c = stdin.readLine.split(" ").map(_.trim.toInt)
        val result = jumpingOnClouds(c, k)

        println(result)
    }
}