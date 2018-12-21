object Roman extends App {
  def toRoman(n: Int): String = 
  	toRomanHelper(n,"")
  def toRomanHelper(n: Int, answer: String): String =
  	if (n == 0) answer
  	else if (n >= 1000) toRomanHelper(n % 1000, answer + "M" * (n / 1000))
  	else if (n >= 900) toRomanHelper(n % 100, answer + "CM")
  	else if (n >= 500 && n < 900) toRomanHelper(n % 100, answer + "D" + ("C" * ((n / 100) - 5)))
  	else if (n >= 400) toRomanHelper(n % 100, answer + "CD")
  	else if (n < 400 && n > 100) toRomanHelper(n % 100, answer + ("C" * (n / 100)))
  	else if (n == 100) toRomanHelper(n % 10, answer + "C")
  	else if (n >= 90) toRomanHelper(n % 10, answer + "XC")
  	else if (n >= 50 && n < 90) toRomanHelper(n % 10, answer + "L" + ("X" * ((n / 10) - 5)))
  	else if (n >= 40) toRomanHelper(n % 10, answer + "XL")
  	else if (n < 40 && n >= 10) toRomanHelper(n % 10, answer + ("X" * (n / 10)))
  	else if (n == 9) toRomanHelper(n % 1, answer + "IX")
  	else if (n >= 5 && n < 9) toRomanHelper(n % 1, answer + "V" + ("I" * ((n / 1) - 5)))
  	else if (n == 4) toRomanHelper(n % 1, answer + "IV")
  	else toRomanHelper(n % 1, answer +  ("I" * (n / 1)))
}