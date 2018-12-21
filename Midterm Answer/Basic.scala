object Basic extends App {

   def numJoyfulBetween(a: Int, b: Int): Int = {
   	numJoyfulBetween_helper_2(a,b,0)
  }

  def numJoyfulBetween_helper(x: Int,digits: List[Int]): Boolean = {
  	val result = BigDecimal(Math.pow(x,11)).toBigInt
  	val to_lst = result.toString.map(_.asDigit).toList
  	if(digits.isEmpty){
  		return true;
  	}
  	else if (to_lst.contains(digits.head) == false){
  		return false;
  	}else{
  		numJoyfulBetween_helper(x,digits.tail)
  	}
  }

  def numJoyfulBetween_helper_2(a: Int, b: Int,count: Int): Int = {
  	if(a > b){
  		return count
  	}
  	else if(numJoyfulBetween_helper(a,List(0,1,2,3,4,5,6,7,8,9)) == true){
  		numJoyfulBetween_helper_2(a+1,b,count+1)
  	}else{
  		numJoyfulBetween_helper_2(a+1,b,count)
  	}
  }

   def kthJoyful(k: Int) = {
   	if(k <= 1){
  		helperHappy(k)
  	}else{
  		helperHappy(kthJoyful(k-1)+1)
  		}
   }
   
  def helperHappy(n: Int): Int = {
  	if(numJoyfulBetween_helper(n) == true){
  		n
  	}else{
  		helperHappy(n+1)
  	}
  }
}
