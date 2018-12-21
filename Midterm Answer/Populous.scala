object Populous extends App {

  def campusesInEduCenter(campusInfo: List[String]) List[String] = {
  	List(winner(campusesInEduCenter_helper(campusesInEduCenter(campusInfo))))

  }

  def campusesInEduCenter_helper(campus: List[String]): List[(String,Int)] = {
  	if(campus.isEmpty){
  		return List()
  	}else{
  		campusesInEduCenter_helper(campus.tail):::List((campus.head.split(",").toList(1),campus.head.split(",").toList(2).toInt))
  	}
  }

  	def winner(xs: List[(String, Int)]): (String, Int) = {
		val max = xs.maxBy(_._2)
		val common = xs.flatMap(t => List(t._1)).groupBy(identity).mapValues(_.size).maxBy(_._2)._1
		val max_2 = winner_helper(xs,common,0)
		if(max._2 > max_2){
			return max
		}else{
			return (common,max_2)
		}
	}

	def winner_helper(xs: List[(String, Int)], element: String, count: Int): Int = {
		if(xs.isEmpty){
			return count;
		}
		else if (xs.head._1 == element){
			winner_helper(xs.tail, element, count + xs.head._2 )
		}else{
			winner_helper(xs.tail, element, count)
		}
	}

  val campusInfo = List(
    "Phayathai,Bangkok,2421",
    "Sanam Chandra,Nakhon Pathom,5493",
    "Salaya,Nakhon Pathom,12145"
    )

  println(campusesInEduCenter_helper(campusInfo))
}


