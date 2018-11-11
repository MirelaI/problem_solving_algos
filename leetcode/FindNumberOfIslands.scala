// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
// An island is surrounded by water and is formed by connecting adjacent lands horizontally
// or vertically. You may assume all four edges of the grid are all surrounded by water.

// DFS approach

// Test cases: 
// [["1", "1", "0", "0", "0"],["1", "1", "0", "0", "0"],["0", "0", "1", "0", "0"],["0", "0", "0", "1", "1"]]
// [["1"],["1"]]

//  Array(
//     Array('1', '1', '1', '1', '0'),
//     Array('1', '1', '0', '1', '0'),
//     Array('1', '1', '0', '0', '0'),
//     Array('0', '0', '0', '0', '0')
// )

import scala.collection.mutable.{ArrayBuffer, Queue}
case class Island(value: Int = 0, var visited: Boolean = false)

object Solution {
    def numIslands(grid: Array[Array[Char]]): Int = {
        val arrayWithMarks: ArrayBuffer[ArrayBuffer[Island]] = grid.map { line => 
            val mutatedLine = line.map { x: Char => Island(x.toString.toInt) }
            mutatedLine.to[ArrayBuffer]
        }.to[ArrayBuffer]

        var numberOfIslands = 0
        
        for (i <- 0 until arrayWithMarks.size) {
            for (j <- 0 until arrayWithMarks(0).size) {
                val current = arrayWithMarks(i)(j)
                if (current.value == 1 && current.visited == false) {
                    dfs(arrayWithMarks, i, j)
                    numberOfIslands += 1
                } else if (current.value == 0) {
                    current.visited = true
                }
            }
        }

        numberOfIslands
    }

    def dfs(grid: ArrayBuffer[ArrayBuffer[Island]], i: Int, j: Int): Unit = {
        val children = new ArrayBuffer[ArrayBuffer[Island]]

        grid(i)(j).visited = true
        val childrenIndices = List(
            (i-1, j), (i+1, j),
            (i, j-1), (i, j+1)
        ).filter { 
            case (a: Int, b: Int) => (a < grid.size && a >= 0) && (b < grid(0).size && b >= 0)
        }

        for ((x, y) <- childrenIndices) {
            val current = grid(x)(y)
            if (current.visited == false && current.value == 1) {
                dfs(grid, x, y)
            }

            current.visited = true
        }
    }

    def main(args: Array[String]): Unit = { 
        val input: Array[Array[Char]] = Array(Array('1'), Array('1'))

        val noIslands = numIslands(input)

        println(noIslands)
    }
}