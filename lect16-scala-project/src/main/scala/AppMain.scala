import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._


object AppMain extends App {
//  println("Hello, World!")
  def fib(n: Int): Long = {
    if (n>48) throw new Exception("too large")
    if (n <= 2) 1
    else fib(n-1) + fib(n-2)
  }

  val f = Future { fib(47)}
  val g: Future[String] = f.map { value => "@@@@" + (value + 1).toString }

  val sleepingFuture: Future[Unit] = Future { Thread.sleep(5000)}
  sleepingFuture.onComplete{
    case _ => println("Pay me now!!")
  }

  val realValueofG = Await.result(g, 2 minutes)
  println(realValueofG)

//  g.onComplete{
//    case scala.util.Success(value) => println(s"success: ${value}")
//    case scala.util.Failure(exception) => println("failed" + exception.toString())
//  }

}
