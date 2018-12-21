object Activity extends App{
	def isPrime(n: Int): Boolean = {
		(n > 1) && (1 to n).count(n % _ == 0) == 2
	}

	def isPrime(n: Int) = {
		n > 1 && (2 to n-1).forall(n % _ != 0)
	}

	val superPrimes = (1 to 5000).filter(isPrime).filter(_.toString.contains("7")).map(_ * 2)



	// def specialfunc(List[Int]): List[Int] = {
	// 	val 
	// }

	def unzip[A, B](xs: List([A, B])): (List[A], List[B]) = xs match {
		case Nil => (Nil,Nil)
		case (a, b)::t => {
			val (as, bs) = unzip(t)
			(a::as,b::bs)
		}
	}

	// xs = ((1,2),(3,4))

	println(unzip(List((1,2),(3,4))))
}