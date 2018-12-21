object Main extends App{

type Person = (String, Double, Int, String)
def prettyPrint(person: Person) = {

}

case class Person(name: String, height: Double, age: Int, address: String)
case class MyPair(_1: Int, _2: String) //behaves similar to tuple

trait Person
case class Programmer(langWritten: List[String]) extends Person
case class Nonprogrammer(langSpoken: String) extends Person

trait Expr
case class Constant(n: Double) extends Expr
case class Neg(e: Expr) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e1: Expr) extends Expr

val e = Sum(Constant(4), Prod(Constant(2), Constant(5)))

def isConstant(e: Expr) = e match {
	case Constant(_) => true
	case _ => false
}

def eval(e: Expr): Double = e match { //how to use this function
	case Constant(n) => n
	case Neg(e) => -eval(e)
	case Sum(e1, e2) => eval(e1) + eval(e2)
	case Prod(e1, e2) => eval(e1) * eval(e2)
}

def stringify(e: Expr): String = e match {
	case Constant(n) => n.toString
	case Sum(e1, e2) => "(" + stringify(e1) + " + " + stringify(e2) + ")"
	case Prod(e1, e2) => "(" + stringify(e1) + " * " + stringify(e2) + ")"
}

}