import scala.concurrent.Future
import scala.concurrent.Promise
import scala.concurrent.ExecutionContext.Implicits.global

object DataCrunch extends App {

  trait DataProvider {
    def get(onSuccess: Seq[String] => Unit,
            onFailure: () => Unit): Unit
  }


  object LoremIpsum extends DataProvider {
    override def get(onSuccess: Seq[String] => Unit,
            onFailure: () => Unit): Unit = {
      val lorem =
        """Lorem ipsum dolor sit amet, consectetur adipiscing elit.
        Cras nec sagittis justo. Nullam dignissim ultricies velit a tempus.
        Aenean pharetra semper elit eu luctus. Fusce maximus lacus eget magna
        ultricies, ac suscipit justo lobortis. Nullam pellentesque lectus
        at tellus gravida rhoncus. Nam augue tortor, rutrum et eleifend id,
        luctus ut turpis. Vivamus nec sodales augue.

        Suspendisse non erat diam. Mauris hendrerit neque at sem laoreet
          vehicula. Sed aliquam urna a efficitur tincidunt. In non purus
        tincidunt, molestie velit vulputate, mollis nisl. Pellentesque
        rhoncus molestie bibendum. Etiam sit amet felis a orci fermentum
        tempor. Duis ante lacus, luctus ac scelerisque eget, viverra ut felis."""
      onSuccess(lorem.split("\n"))
    }
  }

  object FailedSample extends DataProvider {
    override def get(onSuccess: Seq[String] => Unit,
                     onFailure: () => Unit): Unit = {
      onFailure()
    }
  }

  // This returns a DataProvider that feeds the "consumer" all the lines from a
  // file indicated by filename.
  def FileSource(filename: String): DataProvider = new DataProvider {
    override def get(onSuccess: Seq[String] => Unit, onFailure: () => Unit): Unit = {
      try {
        val lines = io.Source.fromFile(filename)
          .getLines
          .toVector
        onSuccess(lines)
      }
      catch {
        case _: Throwable => onFailure()
      }
    }
  }

  // Example of how DataProvider is often used. Comment out the block of code
  // below so it doesn't print some random garbage.
  // def funcOnSuccess(lines: Seq[String]) = lines.foreach(println(_))
  // def funcOnFailure() = println("Failed")
  val sampleProvider = LoremIpsum
  // sampleProvider.get(funcOnSuccess, funcOnFailure)



  def dataProviderFuture(dp: DataProvider): Future[Seq[String]] = {
    val p = Promise[Seq[String]]
    def OnSuccess(lines: Seq[String]) = p.success(lines)
    dp.get(OnSuccess, () => throw new Exception)
    p.future
  }

  // dataProviderFuture(sampleProvider)

  def highestFreq(linesFut: Future[Seq[String]]): Future[(String, Double)] = {
    linesFut.map (
      ls => {
        val arrayWords = ls.flatMap(_.split("\\s+").filter(_.nonEmpty))
        val arrayLength: Double = arrayWords.length
        val count = arrayWords.groupBy(identity).mapValues(_.length/arrayLength)
        count.maxBy(_._2)
      }
    )
  }

  // highestFreq(dataProviderFuture(sampleProvider))
}