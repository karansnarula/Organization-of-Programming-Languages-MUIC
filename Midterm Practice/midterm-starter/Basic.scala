object Basic extends App {

  def numJoyfulBetween(a: Int, b: Int) = {
  	numJoyfulBetweenHelper(a,b,0)
  }

  def numJoyfulBetweenHelper(a: Int, b: Int, count: Int): Int = {
  	if (a > b) {
  		count
  	}
  	else if (isNumJoyful(a) == true) {
  		numJoyfulBetweenHelper(a+1,b,count+1)
  	}
  	else {
  		numJoyfulBetweenHelper(a+1,b,count)
  	}
  }

  def isNumJoyful(number: Int): Boolean = {
  	val num = BigInt(number).pow(11).toString
  	if (num.contains("0") == false) return false
  	if (num.contains("1") == false) return false
  	if (num.contains("2") == false) return false
  	if (num.contains("3") == false) return false
  	if (num.contains("4") == false) return false
  	if (num.contains("5") == false) return false
  	if (num.contains("6") == false) return false
  	if (num.contains("7") == false) return false
  	if (num.contains("8") == false) return false
  	if (num.contains("9") == false) return false
  	return true
  }
  println(numJoyfulBetween(25,69))

  def kthJoyful(k: Int): Int = {
  	kthJoyfulHelper(k,0,0)
  }
  def kthJoyfulHelper(k: Int, number: Int, counter: Int): Int = {
  	if (counter == k){
  		number-1
  	}
  	else if (isNumJoyful(number) == true){
  		kthJoyfulHelper(k,number+1,counter+1)
  	}else{
  		kthJoyfulHelper(k,number+1,counter)
  	}
  }
  println(kthJoyful(16)) 
}
