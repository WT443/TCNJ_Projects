/* 
** Warren Smith
** CSC435-01
** Last Modified: 2/28/14
** Assignment 3: Magic Square Problem
*/


/*
  Creates the magic square object
*/
object MagicSquare 
{
  // Main constructs headings, reading in N value, and runs magic square functions
  def main(args: Array[String]) 
  {
    println("")
    println("Hello, Welcome to the Magic Square Creator.")
    println("-------------------------------------------")
    print("Please enter a # greater than 2 to create the matrix: ")
    val N = readInt()

    // Exception for entering invalid number
    if (N <= 2) 
      throw new RuntimeException("A size of matrix must be bigger than 2")

    // Creates the matrix
    val matrix = Array.ofDim[Int](N, N)

    // Creates and runs OOP version magic square operations
    val oop = new OOP()
    val start0 = System.nanoTime
    if (N % 2 == 1) 
      oop.odd(matrix) 
    else if (N % 4 == 0) 
      oop.doublyEven(matrix) 
    else 
      oop.singlyEven(matrix)
    val end0 = (System.nanoTime - start0) / 1000

    println("")
    println("")
    println("OOP method magic square result:")
    oop.showMagicSqr(matrix)
    println("")
    println("Time to run: " + end0 + " microseconds")
  }
}


/*
  OOP class runs the magic square problem using object oriented programming techniques.
*/
class OOP
{
  // For odd number N matrix
  def odd(magic: Array[Array[Int]]) 
  {
    val N = magic.length
    var row = N - 1
    var col = N / 2
    
    magic(row)(col) = 1
    
    var i = 2

    while (i <= N * N) 
    {
      if (magic((row + 1) % N)((col + 1) % N) == 0) 
      {
        row = (row + 1) % N
        col = (col + 1) % N
      } 
      else 
      {
        row = (row - 1 + N) % N
      }
      magic(row)(col) = i
      i += 1
    }
  }

  // For doubly even N matrix
  def doublyEven(magicsqr: Array[Array[Int]]) 
  {
    val N = magicsqr.length
    val miniSqrNum = N / 4
    var cnt = 1
    var invCnt = N * N
    
    for (i <- 0 until N; j <- 0 until N) 
    {
      magicsqr(i)(j) = 
        if (j >= miniSqrNum && j < N - miniSqrNum) 
          if (i >= miniSqrNum && i < N - miniSqrNum) 
            cnt 
          else 
            invCnt 
          else if (i < miniSqrNum || i >= N - miniSqrNum) 
            cnt 
          else 
            invCnt
      
      cnt += 1
      invCnt -= 1
    }
  }

  // For sigly even N matrix
  def singlyEven(magicsqr: Array[Array[Int]]) 
  {
    val N = magicsqr.length
    val halfN = N / 2
    val k = (N - 2) / 4
    var temp: Int = 0
    val swapCol = Array.ofDim[Int](N)
    val index = 0
    val miniMagic = Array.ofDim[Int](halfN, halfN)
    odd(miniMagic)
   
    for (i <- 0 until halfN; j <- 0 until halfN) 
    {
      magicsqr(i)(j) = miniMagic(i)(j)
      magicsqr(i + halfN)(j + halfN) = miniMagic(i)(j) + halfN * halfN
      magicsqr(i)(j + halfN) = miniMagic(i)(j) + 2 * halfN * halfN
      magicsqr(i + halfN)(j) = miniMagic(i)(j) + 3 * halfN * halfN
    }
    
    for (i <- 1 until k)
    {
      swapCol(index+1) = i
    }

    for (i <- N-k+2 until N)
    {
      swapCol(index+1) = i
    }

    for (i <- 0 until halfN; j <- 0 until index) 
    {
      temp = magicsqr(i - 1)(swapCol(j - 1) - 1)
      magicsqr(i - 1)(swapCol(j - 1) - 1) = magicsqr(i + halfN - 1)(swapCol(j - 1) - 1)
      magicsqr(i + halfN - 1)(swapCol(j - 1) - 1) = temp
    }

    temp = magicsqr(k)(0)
    magicsqr(k)(0) = magicsqr(k + halfN)(0)
    magicsqr(k + halfN)(0) = temp
    temp = magicsqr(k + halfN)(k)
    magicsqr(k + halfN)(k) = magicsqr(k)(k)
    magicsqr(k)(k) = temp
  }

  // Prints out magic square
  def showMagicSqr(magicsqr: Array[Array[Int]]) 
  {
    val N = magicsqr.length
    for (i <- 0 until N) 
    {
      for (j <- 0 until N) 
        System.out.print(magicsqr(i)(j) + " ")
      
      println()
    }
  }
}
