object Reinvent extends App {
  def flatMap[A, B](xs: List[A], f: A => List[B]): List[B] = {
    def flatTail(xs: List[A], acc: List[B]) : List[B] = xs match {
      case h::t => f(h) match {
        case Nil => flatTail(t,acc)
        case res:List[B] => flatTail(t,res++acc)
      }
      case Nil => acc
    }
    flatTail(xs.reverse,List[B]())
  }

  def posNeg(n: Int): List[Int] = {
    require(n>=1, "n must be at least 1")
    flatMap((1 to n).toList, (x:Int) => List(x,-x))
  }
}

