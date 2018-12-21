object Super7 extends App {

  def allPosInts: Stream[Long] = {
  	stream(1)
  }
  def divBySeven: Stream[Long] = {
  	allPosInts.filter(x => x % 7 == 0)
  }
  def divByAndContainsSeven: Stream[Long] = {
  	divBySeven.filter(x => x.toString().contains("7"))
  }

  def nth(n: Int): Long = {
  	divByAndContainsSeven(n-1)
  }

  //some simple tests
  def stream(i: Long = 1): Stream[Long] = i #:: stream(i + 1)

  println(divByAndContainsSeven.take(10).toVector)
  println(Vector(1, 3, 11, 97).map(nth))

  // println(allPosInts.take(20).toList)
  // println(divBySeven.take(20).toList)
  // println(divByAndContainsSeven.take(20).toList)
  // println(nth(97))
}


