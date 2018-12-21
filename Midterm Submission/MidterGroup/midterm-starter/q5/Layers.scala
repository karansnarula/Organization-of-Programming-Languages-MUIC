object Layers extends App {

  // The Tree data type
  sealed trait Tree

  case object Empty extends Tree

  case class Node(key: Long, l: Tree = Empty, r: Tree = Empty) extends Tree

  def getLayer(tr: Tree, k: Int): List[Long] = {
    def getTail(tr: Tree,
                acc: Int,
                res: List[Long])
    : List[Long] = tr match {
      case Node(v, _, _) if k == acc =>
        v :: res
      case Node(_, l, r) =>
        getTail(l, acc + 1, res) ++ getTail(r, acc + 1, res)
      case Empty =>
        res
    }
    getTail(tr, 0, List[Long]())
  }

  def getLayerCPS(tr: Tree, k: Int): List[Long] = {
    def getCPS(tr: Tree, acc: Int, f: List[Long]=>List[Long]): List[Long] = tr match {
      case Node(v, _, _) if k == acc =>
        f(v::Nil)
      case Node(_, l, r) => {
        getTail(l, acc + 1,
          left =>
            getTail(r, acc + 1,
              right =>
                f(left ::: right))
        )
      }
      case Empty =>
        f(Nil)
    }

    getCPS(tr, 0, (r: List[Long]) => r)
  }

}
