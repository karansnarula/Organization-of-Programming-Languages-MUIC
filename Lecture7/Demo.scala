object Main extends App{

	def findMin(xs: List[Int]): Int = {
		if (xs.isEmpty)
			2147483647
		else if (xs.tail.isEmpty) {
			xs.head
		} else if (xs.head < findMin(xs.tail)){
			xs.head
		} else {
		findMin(xs.tail)
		}
	}

	def betterMin(xs: List[Int]): Int = {
		if (xs.isEmpty)
			None
		else if (xs.tail.isEmpty) {
			xs.head
		} 
		else {
			val tailMin = betterMin(xs.tail)
			if(xs.head < tailMin){
				xs.head
			}
			else{
				tailMin
			}
		}
	}

	def betterMinSomeNone(xs: List[Int]): Option[Int] = {
		if (xs.isEmpty)
			None
		else {
			val tailMin = betterMinSomeNone(xs.tail)
			if(tailMin.isEmpty || xs.head < tailMin.get)
				Some(xs.head)
			else
				tailMin
		} 
	}

	def betterMinSomeNonePatternMatch(xs: List[Int]): Option[Int] = xs match {
		case (Nil) => None
		case h::t => betterMinSomeNonePatternMatch(t) {
			case None => Some(h)
			case Some(m) => Some(math.min(h,m))
		}
	}

	def fac(n: Int): Int = {
		def tailFac(n: Int, prod: Int): Int =
			if (n == 0) prod else tailFac(n-1,prod*n)
	}

	def sum(xs: List[Int]): Int = {
		def tailSum(ys: List[Int], acc: Int): Int =
			ys match {
				case None => acc
				case h::t => tailSum(t,acc + h)
			}
	}

	val xs = List(1,2,3,4)
	println(betterMinSomeNone(xs))
}