object Zombies extends App {
  def countBad(hs: List[Int]): Int = {
  	mergeSort(hs,0)._2
  }
  def merge(left: List[Int], right: List[Int], count: Int): (List[Int], Int) = (left, right) match {
        case(left, Nil) => (left, count)
        case(Nil, right) => (right, count)
        case(leftHead :: leftTail, rightHead :: rightTail) =>
          if (leftHead >= rightHead) {
            val t = merge(leftTail, right, count)
            (leftHead :: t._1, t._2)
          }
          else {
            val t = merge(left, rightTail, count + left.size)
            (rightHead :: t._1, t._2)
          }
      }

  def mergeSort(xs: List[Int], count: Int): (List[Int], Int) = {
      val n = xs.length / 2
      if (n == 0) {
        (xs, count)
      }
    else {
      val (left, right) = xs.splitAt(n)
      val leftMergeSort = mergeSort(left, count)
      val rightMergeSort = mergeSort(right, count)
      merge(leftMergeSort._1, rightMergeSort._1, leftMergeSort._2 + rightMergeSort._2)
      }
  }
}