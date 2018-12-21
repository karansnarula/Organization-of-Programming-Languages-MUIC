// package a4

object Spaghetti extends App {

  def spaghetti: Stream[String] = {
    def streamer(string: String): Stream[String] = string #:: streamer(spaghettiHelper(string.head, string, "", 0))
    streamer("1")
  }

  def spaghettiHelper(digit: Char, number: String, answer: String, count: Int): String = {
  	if (number.isEmpty || number.length < 1) {
  		answer + count.toString + digit
  	}
  	else if (digit == number.head) {
  		spaghettiHelper(digit,number.tail,answer,count + 1)
  	}
  	else {
  		spaghettiHelper(number.head,number,answer + count.toString + digit,0)
  	}
  }

  def ham: Stream[String] = {
    def streamer2(n: Int): Stream[String] = hamHelper(n).toStream #::: streamer2(n+1)
    streamer2(1)
  }

  def hamHelper(n: Int): List[String] = {
  	if (n == 1) {
  		List("0", "1")
  	}else {
  		hamHelper(n-1).map("0"+_) ++ hamHelper(n-1).reverse.map("1"+_)
  	}
  }
}
