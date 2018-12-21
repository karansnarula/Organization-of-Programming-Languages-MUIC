val E = new Empty
val A = E.add(5)
val B = A.add(6)
val C = A.add(7)

abstract class IntSet {
	def add(x: Int): IntSet
	def contains(x: Int): Boolean
}


// Changed from class -> object to make it a singleton
object Empty extends IntSet {
	def contains(x: Int) = false
	def add(x: Int) = new NonEmpty(x, this)
}

class NonEmpty extends IntSet {
	def contains(x: Int) = (x==elt) || next.contains(x)
	def add(x: Int) = new NonEmpty(x, this)
}

class Rational(n: Int, d:Int) {

	def this(n: Int) = this(n,1)
	require(d > 0, "Denominator must be positive")
	private def gcd(a: Int,b: Int): Int = {
		if (b==0) a else gcd(b, a%b)
	}
	private val g = gcd(n,d)
    def nummerator = n/g
    def denomerator = d/g

    def add(that: Rational): Rational= {
      val top = this.nummerator * that.denomerator + that.nummerator * this.denomerator
      val bottom = this.denomerator * that.denomerator
      new Rational(top, bottom)
    }

    def mult(that: Rational): Rational = {
      new Rational(this.nummerator * that.nummerator, this.denomerator * that.denomerator)
    }

    def neg(): Rational = {
      new Rational(-this.nummerator, -this.denomerator)
    }

    override def toString: String = nummerator + "/" + denomerator
  }

  //val p = rational(2,3)
  //val q = rational(1,5)
  //p.add(q)

}