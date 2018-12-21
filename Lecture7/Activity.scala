object Main extends App{
	def find(xs: List[(Int,String)], key: Int): Option[String] = {
		if (xs.isEmpty) {
			None
		}
		else if (xs.head._1 == key){
			Some(xs.head._2)
		}
		else{
			find(xs.tail,key)
		}
	}

	def rev(xs: List[Int]): List[Int] = {
		def revTail(ys: List[Int], zs: List[Int]): List[Int] = {
			if (ys.isEmpty) {
				zs
			}
			else {
				revTail(ys.tail,ys.head::zs)
			}
		}
		revTail(xs,List())
	}
	val lst_rev = List(1,2,3,4)
	val lst = List((1,"Karan"),(2,"Arun"),(41,"Rich"),(121,"Dev"))
	println(find(lst,41))
	println(rev(lst_rev))
}