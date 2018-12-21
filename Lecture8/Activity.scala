object Activity extends App {
	def zip(xs: List[Int], ys: List[Int]): List[(Int, Int)] = (xs,ys) match {
		case(Nil,_) => List()
		case(_,Nil) => List()
		case (h::t, h1::t1) => (h,h1) :: zip(t,t1)
	}

	println(zip(List(1,2,3),List(4,6,100)))
	
}