def timesUntilZero(f: Int => Int, x: Int): Int = ??? // return type is (Int => Int, Int)

def lottery(f: Int => Int, n: Int) = {
	if (f(n) % 2 == 0) {
		(x: Double) => x/2.0
	} else {
		(x: Double) => 2.0 * x + 1 // return type: (Int => Int, Int) => (Double => Double)
	}
}

def nTimes(f: A => A, n: Int, x0: A): A = { // f is function from A to A
	assert(n >= 0)
	if (n == 0) x0 else nTimes(f, n - 1, f(x0))
} 

def triple(x: Int) = 3 * x
def addTwo(x: Int) = x + 2
def mult(x: Int, y: Int) = {
	def addX(z: Int) = z + x
	nTimes(addX, y, 0)
}

def doTail[T](xs: List[Int]) = xs.tail

def head(xs: List[Int]): Int = xs match { //exception is of nothing type
	case h::_ => h 
	case _ => throw new RuntimeException("xs cannot be empty")
}

def headString(xs: List[String]): String = xs match { //exception is of nothing type
	case h::_ => h 
	case _ => throw new RuntimeException("xs cannot be empty")
}

def divMod(x: Int, y: Int) = 
	try {
		(x / y, x % y)
	}
	catch {
		case e: ArthmeticException => (0,0)
	}

def findLast(xs: List[Int], k: Int): Option[Int] = {
	def findRec(xs: List[xs], index: Int): Option[Int] = xs match {
		case Nil => None
		case h::t => {
			val tailFound = findRec(t, index + 1) //does this get evaluated right away?
			if (h == k && tailFound.isEmpty) Some(index) else tailFound
		}
	}
}

def findLast(xs: List[Int], k: Int): Option[Int] = {
	case class FoundIndex(location: Int) extends Exception
	def findRec(xs: List[xs], index: Int): Option[Int] = xs match {
		case Nil => None
		case h::t => {
			val tailFound = findRec(t, index + 1)
			if (h == k) FoundIndex(index) else tailFound
		}
	}

	try { findRec(xs, 0) } catch {
		case FoundIndex(index) => Some(index)
	}
}