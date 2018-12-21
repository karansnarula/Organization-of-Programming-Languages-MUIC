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
      def getLayerH(tr: Tree, k: Int): List[Long] = tr match {
        case Empty => List()
        case Node(key, l, r) => k match {
          case _ => k::List()
      }
    }
    getLayerH(tr,k)
  }
}
