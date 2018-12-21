import scala.io.Source

object SimpleWordCount extends App {
	
	def countWords(line: String): Int = {
		line.split("\\W+").length
	}
 
	val wordsPerLine = Source.stdin.getLines.map(countWords).toList
	val lineCount = wordsPerLine.length
	val wordCount = wordsPerLine.sum

	println(s"lineCount: ${lineCount}")
	println(s"wordCount: ${wordCount}")
}