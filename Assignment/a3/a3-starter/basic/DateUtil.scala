object DateUtil extends App {
  type Date = (Int, Int, Int)

  def isOlder(x: Date, y: Date): Boolean = x match {
    case _ if x._3 < y._3 => true
    case _ if (x._3 <= y._3 && x._2 < y._2) => true
    case _ if (x._3 <= y._3 && x._2 <= y._2 && x._1 < y._1) => true
    case _ => false
  }

  def numberInMonth(xs: List[Date], month: Int): Int = xs match {
    case Nil => 0
    case h::t if h._2 == month => numberInMonth(t,month) + 1
    case h::t => numberInMonth(t,month)
  }

  def numberInMonths(xs: List[Date], months: List[Int]): Int = months match {
    case Nil => 0
    case h::t => numberInMonth(xs,h) + numberInMonths(xs,t)
  }

  def datesInMonth(xs: List[Date], month: Int): List[Date] = xs match {
    case Nil => List()
    case h::t if h._2 == month => h::datesInMonth(t,month)
    case h::t => datesInMonth(t,month)
  }

  def datesInMonths(xs: List[Date], months: List[Int]): List[Date] = xs match {
    case Nil => List()
    case h::t if months.contains(h._2) => h::datesInMonths(t,months)
    case h::t => datesInMonths(t,months)
  }

  def dateToString(d: Date): String = {
    val monthlst = List("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
    monthlst(d._2 - 1).toString + "-" + d._1.toString + "-" + d._3.toString
  }

  def whatMonth(n: Int, yr: Int): Int = {
    val leapOrNot = if (isLeapYear(yr)) 1 else 0
    if (n >= 1 && n <= 31) 1
    else if (n >= 32 && n <= (59 + leapOrNot)) 2
    else if (n >= (60 + leapOrNot) && n <= (90 + leapOrNot)) 3
    else if (n >= (91 + leapOrNot) && n <= (120 + leapOrNot)) 4
    else if (n >= (121 + leapOrNot) && n <= (151 + leapOrNot)) 5
    else if (n >= (152 + leapOrNot) && n <= (181 + leapOrNot)) 6
    else if (n >= (182 + leapOrNot) && n <= (212 + leapOrNot)) 7
    else if (n >= (213 + leapOrNot) && n <= (243 + leapOrNot)) 8
    else if (n >= (244 + leapOrNot) && n <= (273 + leapOrNot)) 9
    else if (n >= (274 + leapOrNot) && n <= (304 + leapOrNot)) 10
    else if (n >= (305 + leapOrNot) && n <= (334 + leapOrNot)) 11
    else 12
  }

  def oldest(dates: List[Date]): Option[Date] = {
    if (dates.isEmpty) None
    else Some(oldestHelper(dates,dates.head))
  }

  def isReasonableDate(d: Date): Boolean = {
    val thirtyDayMonths = List(2,4,6,9,11)
    if (d._1 > 31 || d._1 < 1 || d._2 > 12 || d._2 < 1 || d._3 < 1) false
    else if (!isLeapYear(d._3) && d._2 == 2 && d._1 > 28) false
    else if (isLeapYear(d._3) && d._2 == 2 && d._1 > 29) false
    else if (d._1 > 30 && thirtyDayMonths.contains(d._2)) false
    else true
  }

  def oldestHelper(dates: List[Date], date: Date): Date = dates match {
    case Nil => date
    case h::t if (isOlder(h,date)) => oldestHelper(t,h)
    case h::t => oldestHelper(t,date)
  }

  def isLeapYear(year:Int)=if (year%100==0) year%400==0 else year%4==0
}
