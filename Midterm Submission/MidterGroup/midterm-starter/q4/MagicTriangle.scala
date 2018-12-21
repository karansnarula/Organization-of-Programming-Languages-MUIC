object MagicTriangle extends App {
    
  def findHead(n: Int, c: Int) = (3 * (n - 1) + c) % 10

  def upper(n: Int, c: Int): List[Int] = n match{
    case 0 => Nil
    case _ => if (c < 0) 9::upper(n-1, 8) else c::upper(n-1, c-1)
  }

  def addHead(x: List[Int],d: List[List[Int]], res: List[List[Int]]): List[List[Int]] =
    (x,d) match {
      case (xh::Nil, Nil) => List(xh)::res
      case (xh::xt, rh::rt) => addHead(xt,rt,(xh::rh)::res)
    }

  def addTail(x: List[List[Int]], d: List[Int], res: List[List[Int]]): List[List[Int]] =
    (x,d) match {
      case (Nil, rh::rt) => addTail(Nil, rt, List(rh)::res)
      case (xh::xt, dh::dt) => addTail(xt,dt,xh++List(dh)::res)
      case (Nil, Nil) => res
    }

  def triangle(n: Int): List[List[Int]] = {
    def triTail(height: Int, c: Int): List[List[Int]] = height match {

      case a: Int if a <= 3 => a match {
        case 1 => List(c%10) :: Nil
        case 2 =>
          List(c, c + 2).map(x => x%10) :: List(c + 1).map(x => x%10) :: Nil
        case 3 =>
          List(c, c + 5, c + 4).map(x => x%10) :: List(c + 1, c + 3).map(x => x%10) :: List(c + 2).map(x => x%10) :: Nil
      }
      case _ =>
        val fh = findHead(height,c)-1
        val nc = if (fh >= 0) fh else 9
        val up:List[Int] = c :: upper(height-1,nc)
        val left = c + 1 until c + height - 1 map (_%10) toList
        val tayaeng = c+2*height-3 until c+height-2 by -1 map (_%10) toList
        val inside = triTail(height - 3, findHead(height, c))
        val addLeft = addHead(left, inside, Nil).reverse
        val addTayaeng = addTail(addLeft, tayaeng, Nil).reverse
        up :: addTayaeng
    }

    triTail(n,1)
  }


  // Uncomment the code below to pretty print triangles of sizes 1 through 10.
  /*
  def ppTriangle(triangle: List[List[Int]]): Unit = {
    for (row <- triangle) {
      println(row.mkString(" "))
    }
  }

  for (n <- 1 to 10)
    ppTriangle(triangle(n))
   */
}
