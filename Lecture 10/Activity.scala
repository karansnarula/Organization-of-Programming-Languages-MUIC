object Activity extends App{
	def countInRangeFilter(xs: List[Int], lo: Int, hi: Int): Int = {
		val lst = xs.filter(_ >= lo).filter(_ <= hi)
		lst.length
	}
	def mapping(x: Int, lo: Int, hi: Int): Int = {
		if (x >= lo && x <= hi){
			1
		}else{
			0
		}
	}
	def countInRangeMap(xs: List[Int], lo: Int, hi: Int): Int = {
		// if (xs.nonEmpty){
			xs.map(x => mapping(x,lo,hi)).toList.sum
		// }
	}
	println(countInRangeMap(List(100,800,30,10000,50,70),4,8))
}

