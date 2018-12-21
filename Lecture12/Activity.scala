object Activity extends App {

	def fibCPS(n : Int) : Long = n match {
   		def fibRec(n: Int, K: Long => Long): Long = n match {
   			case 1 | 2 => K(1)
   			case _ => fibRec(n-1,a => fibRec(n-2,b => K(a + b))
   		}
   		fibRec(n, (x: Long) => x)
	}