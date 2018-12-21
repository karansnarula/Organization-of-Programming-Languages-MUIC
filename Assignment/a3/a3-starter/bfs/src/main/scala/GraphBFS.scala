object GraphBFS {

  def bfs[V](nbrs: V => Set[V], src: V) = {

    def expand(frontier: Set[V], parent: Map[V, V]) = {
      val nFront = frontier.flatMap(x => nbrs(x).filter(y => !parent.contains(y)))
      val nParent = frontier.flatMap(x => nbrs(x).filter(y => !parent.contains(y)).flatMap(y => Map(y -> x) )).toMap ++ parent
      (nFront,nParent)
    }

    def iterate(frontier: Set[V], parent: Map[V, V], distance: Map[V, Int], d: Int): (Map[V, V], Map[V, Int]) =
      if (frontier.isEmpty)
        (parent, distance)
      else {
        val (frontier_, parent_) = expand(frontier, parent)
        val distance_ = frontier_.flatMap(x => Map(x -> d)).toMap ++ distance

        iterate(frontier_, parent_, distance_, d + 1)
      }

    iterate(Set(src), Map(src -> src), Map(), 0)
  }

}






