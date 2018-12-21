object Demo extends App {

	def isPrime(n: Int): Boolean = 
		(2 until n) forall {d => n % d != 0}

	(1000 to 10000).filter(isPrime)(1)


	def fib(n: Int): Long = 
		if (n <= 2) 1 else fib(n - 1) + fib(n - 2)

	def fib(n: Int): Long = {
		def fibRec(i: Int, p1: Int, p2: Int): Long {
			if(i == n) p1
			else fibRec(i+1, p1+p2, p1)
		}
		fibRec(1,1,0)
	}
	def fibStream = Stream.from(1).map(fib)

	def fibStream: Stream[Long] = {
		def fibRec(p1: Long, p2: Long): Stream[Long] = 
			p1 #:: fibRec(p2, p1 + p2)
  		fibRec(0, 1)

	}

	def primes: Stream[Int] = {
		def sieve(s: Stream[Int]): Stream[Int] = s match {
			case p #:: t => p #:: sieve(t.filter(_ % p != 0))
		}
		sieve(Stream.from(2))
	}

	def isOdd(n: Int): Boolean = 
		(1 until n) forall {d => n % 2 != 0}

	def allOdd(a: Int): Stream[Int] =
		Stream.from(1).takeWhile(_ <= a).filter(isOdd)

	def postNeg(n: Int): Stream[Int] = {
		val neg = (x: Int) => Stream(x,-x) 
		Stream.from(1).flatMap(neg)
	}

	val allPrimesBetween1kand10k =
		between(1000,10000).filter(isPrime)

	def between(a: Int, b: Int): Stream[Int] =
		Stream.from(a).takeWhile(_ <= b)

	// val a = between(2,5)
	// println(a.tail)

	def from(n: Int): Stream[Int] = n #:: from(n+1)

	// println(from(10))
	
	def toN(n: Int): Stream[Int] = {
		import Stream.empty
		def next(i: Int): Stream[Int] =
			if (i > n) empty
			else i #:: next(i+1)

		next(1)
	}


}