import scala.concurrent.{Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global;

object Calls extends App {

  type Callback[T] = Option[T] => Unit

  def resolveDivision(userIdFromLoginName: String => Callback[String] => Unit,
                   majorFromUserId: String => Callback[String] => Unit,
                   divisionFromMajor: String => Callback[String] => Unit,
                   loginName: String): Future[String] = {
  // TODO: implement this function 
    userIdFromLoginName(Some(loginName)).flatMap(Some(majorFromUserId)).flatMap(Some(divisionFromMajor)).flatMap(Some(averageScoreFromDivision)).getOrElse(None)
  }


  object MockFunctions {
    def userIdFromLoginName(loginName: String)(cb: Callback[String]): Unit = cb(Some("12345"))
    def majorFromUserId(userId: String)(cb: Callback[String]): Unit = cb(Some("ICCS"))
    def divisionFromMajor(major: String)(cb: Callback[String]): Unit = cb(Some("SCIENCE"))
  }

  // example run

  val division: Future[String] = resolveDivision(
    MockFunctions.userIdFromLoginName,
    MockFunctions.majorFromUserId,
    MockFunctions.divisionFromMajor,
    "yoyoyo")
}
