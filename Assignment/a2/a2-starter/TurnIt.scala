object TurnIt extends App {
  def transpose(A: List[List[Int]]): List[List[Int]] = {
  	transposeHelper(A,List(),List(),List(),A.head.length)
  }
  def transposeHelper(A: List[List[Int]], A_truncated: List[List[Int]], B: List[List[Int]], lst: List[Int], column: Int): List[List[Int]] = {
    if(column <= 0){
      B.reverse
    }
    else if (A.nonEmpty) {
      transposeHelper(A.tail,A.head.tail::A_truncated,B,A.head.head::lst,column)
    }
    else {
      transposeHelper(A_truncated.reverse,List(),lst.reverse::B,List(),column - 1)
    }
  }
}