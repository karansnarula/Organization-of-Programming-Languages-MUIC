import scala.io.Source

object Thesaurus extends App {

  val defaultEncoding = "ISO8859-1"

  def load(filename: String):Map[String,Set[String]] =  {
    val lines =  Source.fromFile(filename,defaultEncoding).getLines.drop(1).toList
    val thesaurusMap: Map[String,Set[String]] = helpMap(lines,Map())
    thesaurusMap
  }

  def helpMap(lines:List[String], mapRet:Map[String,Set[String]]):Map[String,Set[String]] = lines match {
    case Nil => mapRet
    case  h::t => {
      if (h.isEmpty) mapRet
      else {
        val line = h.split("\\|")
        val (word: String, group: String) = (line.head, line.tail.head)
        val stemWord: String = word.trim()
        val groupNum = group.trim().toInt
        val stemWords: Set[String] = t.take(groupNum).flatMap(x => x.split("\\|").tail).toSet
        val trimStemWords = stemWords.map(x => x.trim)
        val newLine = t.drop(groupNum)
        helpMap(newLine, mapRet + (stemWord -> trimStemWords))
      }
    }
  }

  def linkage(thesaurusFile: String): String => String => Option[List[String]] = {
    val thesaurusDb:Map[String,Set[String]]= load(thesaurusFile)

    def nbrs(wordA:String): Set[String]= {
      if (thesaurusDb.contains(wordA)){
          thesaurusDb(wordA)
        }
      else {
        Set()
        }
    }
    def pathA(wordA:String): String => Option[List[String]] = {
      val (synonym,_):(Map[String,String], Map[String, Int]) = GraphBFS.bfs(nbrs,wordA)

      def pathBtoA(wordB:String):Option[List[String]] = {

        def helper(wordB:String,lst:Option[List[String]]): Option[List[String]] = {
          if (synonym.contains(wordB) && wordB.equals(wordA)) {
            Some(wordA::lst.get)
          }
          else if (synonym.contains(wordB))  {
            val nextWord:String= synonym(wordB)
            helper(nextWord, Some(wordB::lst.get))
          }
          else {
            None
            }
        }
        helper(wordB,Some(List()))
      }
      pathBtoA
    }
    pathA
  }
}
