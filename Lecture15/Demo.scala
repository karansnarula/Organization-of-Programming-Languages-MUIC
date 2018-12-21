object MyGreatestController {
	val conn = DBConnRepo.getByName("appDBConnection")
}

trait FooService {
	def foo: String
}

trait DefaultFoo extends FooService {
	def foo = "default foo"
}

trait LuxuriousFoo extends FooService {
	def foo = "exclusive foo"
}

trait BarUsingFooService {
	this: FooService =>

	def bar = "bar uses foo: " + foo
}

object Main extends App {
	val usingDefaultFoo = new BarUsingFooService with DefaultFoo
	val usingLuxuriousFoo = new BarUsingFooService with LuxuriousFoo
	println(usingDefaultFoo.bar)
	println(usingLuxuriousFoo.bar)
}

sealed trait BT[+T]
object Leaf extends BT[Nothing]
case class Node[T](k: T, l: BT[T], r: BT[T]) extends BT[T]


sealed trait MyList[+T]
object MyNil extends MyList[Nothing]
case class MyCons[T](h: T, t: MyList[T]) extends MyList[T]




class ClassName
object ObjectName
trait TraitName
type Hello = (Int, String)

def foo(x: ClassName)
def bar(x: TraitName)
def baz(x: ObjectName.type)
def foz(x: TypeName)


//dot type refer to object and without dot type refer to class
// Upper Bound: A <: B (A "extends" B)
// Lower Bound: A >: B (B "extends" A)


abstract class Animal {
	def name: String
}

abstract class Pet extends Animal {}

class Cat extends Pet {
	override def name: String = "Cat"
	def meow: String = "Say meow"
}

class Dog extends Pet {
	override def name: String = "Dog"
	def bark: String = "Woof!"
}

class Lion extends Animal {
	override def name: String = "Lion"
	def roar: String = "Roar!"
}

class Cage[+P <: Pet](p: P) {
	def pet = p
}

// return (name, a caged animal)
def getNameCage[T <: Pet](animal: T): (String, Cage[T]) = {
	(animal.name, new Cage(animal))
}

// Co-variance: if A == B, then C[A] == C[B]
// Invariance: if A -> B, then C[A]->C[B]
// Contra: if B->A, then C[A]->C[B]