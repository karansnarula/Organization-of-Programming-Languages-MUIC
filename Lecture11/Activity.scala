import scala.io.Source
object Activity extends App {
	
	def countWords(line: String): Int = {
		line.split("\\W+").length
	}

	val wordsPerLine = Source.stdin.getLines.map(countWords).toSet
	println(wordsPerLine)
}