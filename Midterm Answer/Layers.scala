object Layers {
  sealed trait Tree
  case object Empty extends Tree
  case class Node(key: Int, l: Tree, r: Tree) extends Tree


  def sumLayer(tr: Tree, k: Int) = ???

  val tr = Node(5,
                Node(12, Node(25,
                              Node(9, Empty, Empty), Empty),
                     Empty), Node(13,
                                  Node(1, Empty, Empty), Node(7, Empty, Empty)))
}
