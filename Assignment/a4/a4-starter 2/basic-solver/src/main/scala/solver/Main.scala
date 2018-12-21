package solver

object Solver extends App {
  // solves expString == 0 for the variable in varName with an initial guess
  // specified. We'll assume that the given expression has a root.

  def solve(expString: String, varName: String, guess: Double): Double = {
    val ex: Option[Expression] = Parser(expString)
    // TODO: complete the implementation. This will construct the 
    // appropriate functions and call Newton.solve
    val exDiff = Process.differentiate(ex.get,varName)
    val mapp = Map(varName -> guess)
    val func = (g:Double) => Process.eval(ex.get,Map(varName -> g))
    val diff = (g:Double) => Process.eval(Process.differentiate(ex.get,varName), Map(varName -> g))
    Newton.solve(func,diff,guess)
//    throw new Exception("Not yet completed") // <- remove me when you're done
  }
  // println(solve("x^2 - 4.0", "x", 1.0))
}
