package solver

object Newton {

  // your implementation of the Newton method that takes a function f: Double => Double
  // and its derivative df: Double => Double  (take note of the types),
  // and computes a root of f using the Newton's method with the given 
  // guess: Double starting value

  def solve(f: Double => Double, df: Double => Double, 
            guess: Double): Double = {

//    throw new Exception("Not yet implemented") // replace me with real code
    def great(guess: Double): Boolean = {
      math.abs(f(guess)) < 1e-20
    }
    def evenBetter(g:Double) = {
      g - f(g)/df(g)
    }
    def repeat(g:Double): Double = {
      if (great(g)) g else {
        repeat(evenBetter(g))}
    }
    repeat(guess)
  }

}
