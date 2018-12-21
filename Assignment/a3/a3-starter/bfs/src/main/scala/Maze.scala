object Maze extends App{
  def solveMaze(maze: List[String]): Option[String] = {
    val mazeString:String = maze.foldLeft("") ((acc,elt) => acc + elt)
    val start:Int = mazeString.indexOf("s")
    val end:Int = mazeString.indexOf("e")
    val row:Int= maze.head.length

    def nbrs(i:Int): Set[Int] = {
      Set(i+1,i-1,i+row,i-row).filter(h => mazeString.charAt(h) != 'x')
    }
    val (shortestPath, _) = GraphBFS.bfs(nbrs,start)

    def pathFinder(currentPosition:Int,direction:String): Option[String] = {
      val (up,down,left,right) = (currentPosition + row,currentPosition - row,currentPosition + 1,currentPosition -1)
      val nextCurrentPosition = shortestPath.get(currentPosition).get
      if (currentPosition == start) Some(direction)
      else if (nextCurrentPosition == up)  pathFinder( nextCurrentPosition, "u" + direction )
      else if (nextCurrentPosition == down) pathFinder( nextCurrentPosition,"d" + direction )
      else if (nextCurrentPosition == left ) pathFinder( nextCurrentPosition, "l" + direction )
      else pathFinder(nextCurrentPosition,"r" + direction )
    }
    if (shortestPath.contains(end)) (pathFinder(end,"")) else None
  }
}
