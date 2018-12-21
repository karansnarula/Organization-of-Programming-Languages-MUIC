object MagicTriangle extends App {

  def triangle(n: Int): List[List[Int]] = {
    triangleCreater(n,List())
  }

  def triangleCreater(n: Int, lst:List[List[Int]]): List[List[Int]] = {
    if (n <= 0){
      lst
    }else{
      triangleCreater(n-1,List(n)::lst)
    }
  }

println(triangle(5))

  // Uncomment the code below to pretty print triangles of sizes 1 through 10.
  
//   def ppTriangle(triangle: List[List[Int]]): Unit = {
//     for (row <- triangle) {
//       println(row.mkString(" "))
//     }
//   }

//   for (n <- 1 to 10)
//     ppTriangle(triangle(n))
   
}
