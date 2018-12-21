object FilterMap extends App {
  def map[A, B](f: A => B, xs: List[A]): List[B] = {
  	mapHelper(f,xs,List())
  }
  def mapHelper[A, B](f: A => B, xs: List[A], ys:List[B]): List[B] = {
  	if (xs.isEmpty){
  		ys
  	}
  	else{
  		val value = f(xs.head)
  		mapHelper(f,xs.tail,ys:+value)
  	}
  }

  def filter[A](p: A => Boolean, xs: List[A]): List[A] = {
  	filterHelper(p,xs,List())
  }
  def filterHelper[A](p: A => Boolean, xs: List[A], ys: List[A]): List[A] = {
  	if(xs.isEmpty){
  		ys
  	}
  	else{
  		if(p(xs.head) == true){
  			filterHelper(p,xs.tail,ys:+xs.head)
  		}
  		else{
  			filterHelper(p,xs.tail,ys)
  		}
  	}
  }

}
