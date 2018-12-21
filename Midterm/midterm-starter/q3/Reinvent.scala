object Reinvent extends App {
  def flatMap[A, B](xs: List[A], f: A => List[B]): List[B] = {
	xs.foldLeft(List[B]())(_ ++ f(_))
  }
  val foo = (x: Int) => if (x < 0) Nil else List(1,x,x*x)
  val xs = List(3,-4,-5,2)
  val ys = flatMap(xs,foo)
  println(ys)
  def posNeg(n: Int): List[Int] = {
    // require(n>=1, "n must be at least 1")
    val lst = (1 to n).toList
  	def negate(y: Int) = List(y,-y)
  	lst.flatMap(x => negate(x))
  }
  println(posNeg(5))
}
