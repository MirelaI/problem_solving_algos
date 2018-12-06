
object ScalaCollections {
  // Notes

  // Sum in terms of foldLeft
  def sum(myList: List[Int]): Int = {
    myList.foldLeft(0) { (sum, a) => sum + a }
  }

  def map[A, B](myList: List[A])(f: A => B ): List[B] = {
    myList.foldLeft(List.empty[B]) { (l, a) => l :+ f(a) }
  }

  def main(args: Array[String]): Unit = {
    println(sum(List(1, 2, 3, 4)))
    println(map(List(1,2,3,4)()))
  }
}
