object HelloWorld extends App{
	// println("Hello, World")
	and(false,true)
}


def foobar = {
	val magic = {
		val potion1 = 42
		val potion2 = if (isPrime(100001)) 10 else 43
		potion1 + potion1*potion2
	}
	magic*5
}

val moo = if (x > 0) {
	val potion1 = 42
	val potion2 = if (isPrime(100001)) 10 else 43
	potion1 + potion1*potion2
}else{
	49
}

def and(x: Boolean, y: Boolean) = {
	if (x) y else false
}

def or(x: Boolean, y: Boolean) = {
	if (false) y else true
}

def sumOfSquares(x: Int, y: Int) = {
	def sqr(t: Int) = t*t
	val xx = sqr(x)
	val yy = sqr(y)
	xx + yy
}

//Newtons Method

def computeE = {
	def df(x: Double) = 1.0 / x
	def f(x: Double) = math.log(x) - 1
	def goodEnough(x: Double) = math.abs(f(x)) < 1e-9
	def improve(x: Double) = x - f(x)/df(x)
	def repeat(x: Double): Double = 
		if (goodEnough(x)) x else repeat(improve(x))

	repeat(1.0)
}

