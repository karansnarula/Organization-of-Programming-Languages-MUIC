val xs = List((3,"hi"),(4,"hello"))

xs match{
	case(i, s)::(j, t)::_ if i==j =>
}

def quantify(num: Int) = num match {
	case n if n > 100 => n.toString + " is large"
	case n if n > 10 => n.toString + " is big"
	case _ => "otherwise"
}

def findMin(xs: List[Int]): Option[Int] = xs match {
	case Nil => None
	case h::Nil => Some(h)
	case h::t => Some(math.min(h, findMin(t).get))
}

val x: Option[(String, Int)] = None
val Some((s, i)) = x

x match {
	case Some((s, i)) => 
}

def nth[T](xs: List[T], k: Int): T = {
	if (k == 0) xs.head else nth(xs.tail, k-1)
}

def zip[A, B](xs: List[A], ys: List[B]): List[(A,B)] = (xs, ys) match {
	case (Nil,Nil) => Nil
	case (x::xs, y::ys) => (x,y) :: zip(xs,ys)
	case _ => ??? //should never happen
}

xs.map // maps anything to the list
xs.filter // filter anything to the list 

sealed trait MyOption[+T]
case object MyNone extends MyOption[Nothing]
case class MySome[T](value: T) extends MyOption[T]
