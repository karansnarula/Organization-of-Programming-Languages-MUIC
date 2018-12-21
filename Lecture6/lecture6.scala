object Main extends App {

	def pow(x: Int, w:Int): Int = 
		if (w == 0) 1
		else x * pow(x, w-1)

	def factorial(n: Int): Long =
		if (n == 0) 1
		else n * factorial(n-1)

	def swap(p: (String, Int)) = 
		(p._2, p._1)

	def foo(p1: (Int,Int), p2: (Int,Int)) = 

	def divMod(x: Int, y: Int)

	def decrList(n: Int): List[Int] = {
		if (n == 0) List(0)
		else n::decrList(n-1)
	}

	def decrListMatch(n: Int): List[Int] = n match {
		case(0) => List(0)
		case _ => ???
	}

	def concat(xs: List[Int], ys: List[Int]): List[Int] = xs match{
		case(Nil) => ys
		case h::t => h::concat(t,ys)
	}
}

