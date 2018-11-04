import scala.collection.mutable.{Map, ArrayBuffer}

class LRUCache(_capacity: Int) {
    private val cache: Map[Int, Int] = Map[Int, Int]()
    private val orderOfUse: ArrayBuffer[Int] = new ArrayBuffer[Int]()

    def get(key: Int): Int = {
        if (cache.get(key).isDefined) {
            updateOrderOfUse(key)
            cache(key)
        }  else -1 
    }

    def put(key: Int, value: Int) =  {
        if (cache.size >= _capacity && cache.get(key).isEmpty) { 
            val leastUsed = leastUse
            orderOfUse -= leastUsed
            cache -= leastUsed
        }

        updateOrderOfUse(key)
        cache(key) = value
    }

    def updateOrderOfUse(key: Int) = {
        if (cache.get(key).isDefined) orderOfUse -= key

        orderOfUse += key
    }

    def leastUse: Int = orderOfUse.head
}

object Solution {
    def main(args: Array[String]): Unit = {
    // ["LRUCache","put","put","get","put","get","put","get","get","get"]
    // [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        val cache = new LRUCache(2)
        cache.get(2)
        cache.put(1, 1)
        cache.put(2, 2)
        cache.get(1)
        cache.put(3, 3)
        cache.get(2)
        cache.put(3, 3)
        cache.get(1)
        cache.get(3)
        cache.get(4)
    }
}