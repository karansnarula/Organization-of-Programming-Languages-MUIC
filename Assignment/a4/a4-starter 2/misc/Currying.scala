package a4

object Currying extends App {

  // the exception NoAnswer that you will refer to
  case object NoAnswer extends Exception

  // declare your firstAnswer method here
  // it should be of type (A => Option[B]) => List[A] => B

  // declare your allAnswers method here
  // it should be of type (A => Option[List[B]]) => List[A] => Option[List[B]]
}
