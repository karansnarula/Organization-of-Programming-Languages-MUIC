object Reinvent {

	def flatMap[A, B](xs: List[A], f: A => Seq[B]): List[B] = {
  		xs.foldLeft(List[B]())(_ ++ f(_))
  	}
  	def posNeg(n: Int): List[Int] = {
  		if(n == 0){
  			List()
  		}else{
  			posNeg(n-1):::List(n,n * -1)
  		}
  	}
}
