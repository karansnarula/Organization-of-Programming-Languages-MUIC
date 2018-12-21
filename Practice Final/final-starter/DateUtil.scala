object DateUtil extends App {

  // Implement a SimpleDate class here. Feel free to delete
  // the declaration below. It's only here now so that range
  // knows about SimpleDate
  class SimpleDate(d: Int, m: Int, y: Int) extends Ordered[SimpleDate] {

    val monthlst: List[String] = List("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
    val thirtyDayMonths: List[Int] = List(2,4,6,9,11)
    override def toString: String = monthlst(m - 1) + " " + d + ", " + y
    def day: Int = d
    def month: Int = m
    def year: Int = y
    def next: SimpleDate = {
      if ((d == 30 && thirtyDayMonths.contains(m)) || (d == 31 && !thirtyDayMonths.contains(m))) new SimpleDate(1,m+1,y)
      else if ((d == 28 && m == 2 && !isLeapYear(y)) || (d == 29 && m == 2 && isLeapYear(y))) new SimpleDate(1,3,y)
      else if (d==31 && m == 12) new SimpleDate(1,1,y+1)
      else new SimpleDate(d+1,m,y)
    }

    override def compare(that: SimpleDate) = {
      // that is smaller
      if (year > that.year) 1
      else if (year == that.year && month > that.month) 1
      else if (year == that.year && month == that.month && day > that.day) 1
      else if (year == that.year && month == that.month && day == that.day) 0
      else -1
    }

  }

  def range(from: SimpleDate, to: SimpleDate): Vector[SimpleDate] = {
    if (from.day == to.day && from.month == to.month && from.year == to.year) Vector()
    else from +: range(from.next,to)
  }


  def isLeapYear(year:Int)=if (year%100==0) year%400==0 else year%4==0

  // Some simple test code. For this to work, you'll need to implement a proper
  // toString method.

  val d = new SimpleDate(15,6,2017)
  val a = new SimpleDate(15,7,2017)
  // println(d.toString)
  // println(d.month)
  // println(d.next.next)
  // println(range(d,a))
  // println(d.next)
  // println(d.next.next)
  println(d < d.next)
  println(Ordering[SimpleDate].compare(d, d.next))

// val examDate1 = new SimpleDate(2, 2, 1996)
//   val examDate2 = new SimpleDate(27, 2, 1996)
//
//  println(==(examDate1,examDate2))
//  println((examDate1 , examDate2))

  // val g = range(examDate1, examDate2).foreach(x => {
  //   println(x.toString)
  // })






}
