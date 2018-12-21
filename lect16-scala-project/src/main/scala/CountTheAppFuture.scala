import scala.io.Source

object CountTheAppFuture extends App {

  def httpGet(url: String): String =
    Source.fromURL(url, "utf-8").mkString

  def tokenize(contents: String): Array[String] =
    contents.split("""\W+""").map(_.toLowerCase)

  def countKeyword(keyword: String)(tokenArray: Seq[String]): Int =
    tokenArray.count(_ == keyword)


  def countTheFromUrl(url: String) = {
    httpGet(url)
      .map(tokenize)
      .map(countKeyword("the")(_))


//    println(s"httpGet: ${url}")
//    val contents = httpGet(url)
//    println(s"tokenize: ${url}")
//    val tokens = tokenize(contents)
//    val countThe = countKeyword("the") _
//    println(s"count: ${url}")
//    val count = countKeyword("the")(tokens)
//
//    count
  }

  val webUrls = Vector(
    "http://www.muic.mahidol.ac.th/eng",
    "http://www.apache.org",
    "https://www.scala-lang.org",
    "https://www.wikipedia.org"
  )

  val counts = webUrls.map(countTheFromUrl)
  println(webUrls.zip(counts))
}
