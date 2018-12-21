object BetterExpr {
	trait Expr { //trait is interface
		def +(that: Expr) = Sum(this, that)
		def *(that: Expr) = Prod(this, that)
		def unary_(that: Expr) = Negate(this)
		def toVal: Double // = eval(this)
	}
	case class Var(name: String) extends Expr
	case class Const(n: Double) extends Expr {
		def toVal = n
	}
	case class Negate(e: Expr) extends Expr {
		def toVal = -e.toVal
	}
 	case class Sum(e1: Expr, e2: Expr) extends Expr {
 		def toVal = e1.toVal + e2.toVal
 	}
	case class Prod(e1: Expr, e2: Expr) extends Expr {
		def toVal = e1.toVal * e2.toVal
	}

	val expr = x*x + x*(x+x*x)
}

def eval(e: Expr) = e match {
	case Const(n) => n
	case Negate(e) => -eval(e)
	case Sum(e1,e2) => eval(e1) + eval(e2)
	case Prod(e1,e2) => eval(e1) * eval(e2)
}
