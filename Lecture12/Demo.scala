//Contination Passing Style (CPS)

def add(x: Int, y: Int, z: Int) = x + y + z
def addCurried(x: Int)(y: Int)(z: Int) = (x + y + z).toString //allows for partial application of the function

val foo = (x: Int) => (y: Int) => (z: Int) => (x + y + z).toString

sealed trait Tree
case object Empty extends Tree
case class Node(key: Int, left: Tree = Empty, right: Tree = Empty) extends Tree

val testTree = Node(5,Node(2),Node(7,Node(6),Node(9)))

def walk(t: Tree): List[Int] = t match {
	case Empty => Nil
	case Node(k, l, r) => walk(l) ++ List(k) ++ walk(r)
}

def walkTail(t: Tree): List[Int] = t match {

}

def walkCps(t: Tree): List[Int] = {
	def walkRec(t: Tree, K: List[Int] => List[Int]) = t match {
       
	}
}

def gemsWhile(condition: => Boolean)(block: => Unit): Unit = {
	if (condition) {
		block
		gemsWhile(condition)(block)
	} else()
}


def add(x: Int, y: Int, z: Int) = (x + y + z).toString
	def addCurried(x: Int)(y: Int)(z: Int) = (x + y + z).toString

	val foo = (x: Int) => (y: Int) => (z: Int) =>
	(x + y + z).toString

	sealed trait Tree
	case object Empty extends Tree
	case class Node(
		key: Int, 
		left: Tree = Empty, 
		right: Tree = Empty) extends Tree

	val testTree = 
		Node(5, 
			Node(2), 
			Node(7, 
				Node(6), 
				Node(9)
				)
			)

	def walk(t: Tree): List[Int] = t match {
		case Empty => Nil
		case Node(k, l, r) =>
			val leftList = walk(l)
			val rightList = walk(r)
			leftList ++ List(k) ++ rightList 
	}

	// def walkTail(t: Tree): List[Int] = t match {
	// 	def walkRec(t: Tree, aux: Int): List[Int] = t match {
	// 		case Nil => aux
	// 		case Node(k, l, r) => walkRec(l,k::aux)
	// 	} 
	// } 

	def walkCps(t: Tree): List[Int] = {
		def walkRec(t: Tree, K: List[Int] => List[Int]) = t match {
			case Empty => K(Nil)
			case Node(k, l, r) =>
				walkRec(l, leftList => 
					walkRec(r, rightList =>
						K(leftList ++ List(k) ++ rightList)))
		} 
	} 

	def sum(xs: List[Int]): Int = xs match {
		case Nil => 0
    	case x :: t => x + sum(t)
  	}
	def sumTail(xs: List[Int]): Int = {
		def sumRec(xs: List[Int], a: Int) = xs match {
			case Nil => a
			case x::xs => sumRec(xs, a + x)
		}

		sumRec(xs,0)
	}

	def sumCps(xs: List[Int]): Int = {
		def sumRec(xs: List[Int], K: Int => Int): Int = xs match {
			case Nil => K(0)
			case x::xs => sumRec(xs, r => K(r + x))
		}
		// K acts as a function to return 
		sumRec(xs, (x: Int) => x)
	}
}