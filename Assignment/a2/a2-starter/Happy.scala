object Happy extends App {
  // todo: write these functions!
  def sumOfDigitsSquared(n: Int): Int = {
  	if (n < 10){
  		n * n
  	}
  	else{
  		(n % 10) * (n % 10) + sumOfDigitsSquared(n / 10)
  	}
  }
  def isHappy(n: Int): Boolean = {
  	if (n == 1){
  		true
  	}
  	else if (n == 4 || n == 0){
  		false
  	}
  	else{
  		isHappy(sumOfDigitsSquared(n))
  	}
  }
  def kThHappy(k: Int): Int = {
  	kThHappyHelper(k, 0, 0)
  }

  def kThHappyHelper(k: Int, count: Int, answer: Int): Int = {
  	if (count == k){
  		answer - 1
  	}
  	else if (isHappy(answer) == true){
  		kThHappyHelper(k, count + 1, answer + 1)
  	}
  	else {
  		kThHappyHelper(k, count, answer + 1)
  	}
  }
}