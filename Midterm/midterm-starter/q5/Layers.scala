object Layers extends App {

  // The Tree data type
  sealed trait Tree
  case object Empty extends Tree
  case class Node(key: Long, l: Tree = Empty, r: Tree = Empty) extends Tree


  val example = Node(5,
                     Node(12,
                          Node(25,
                               Node(9), Empty),
                          Empty),
                     Node(13,
                          Node(1),
                          Node(7)))
  def getLayer(tr: Tree, k: Int): List[Long] = {
    if (k < 0) {
      return Nil
    }
    else {
      tr match {
        case Empty => Nil
        case _ => {
          val node = tr.asInstanceOf[Node]
          if(k==0) List(node.key)
          else {
            getLayer(node.l, k-1) ++ getLayer(node.r, k-1)
          }

        }
      }
    }
  }
  println(getLayer(example,2))
}
