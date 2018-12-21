object Demo extends App {

	val magicSecret = 42
	def foo(x: Int) = {
		val t = 1 + x

		magicSecret + t
	}

	def mkFibFoo1(t: Int) = {
		(x: Long) => fib(t) + x
	}
     
	def forAll[T](xs: List[T], p: T => Boolean): Boolean = {
		xs match {
			case Nil => true
			case h::t => p(h) && forAll(t, p)
		}
	}

	def isPrimeForAll(n: Int) = {
		n > 1 && (2 to n-1).forAll(n % _ != 0)
	}

	def isPrimeExists(n: Int) = {
		n > 1 && !(2 to n-1).exists(n % _ == 0)
	}

	def convertBoolList(st: String): List[Boolean] = {
		st.split(",").toList.map.(_.toBoolean )
	}



}

/*
Lexical scoping: The body of a function is evaluated in the environment where that func is defined (as opposed to the environment where the function is called)
*/

