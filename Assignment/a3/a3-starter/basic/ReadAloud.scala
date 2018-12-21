object ReadAloud extends App {
  def readAloud(lst: List[Int]): List[Int] = {
  	readAloudHelper(lst,lst.head,0,List()).reverse
  }
  def readAloudHelper(lst: List[Int], elem: Int, count: Int, finallist: List[Int]): List[Int] = {
  	if (lst.isEmpty) {
  		return elem::count::finallist
  	}
  	else if (lst.head == elem){
  		readAloudHelper(lst.tail,elem,count+1,finallist)
  	}
  	else{
  		readAloudHelper(lst,lst.head,0, elem::count::finallist)
  	}
  }

  def unreadAloud(rlst: List[Int]): List[Int] = {
    unreadAloudHelper(rlst,rlst.head,List()).reverse
  }

  def unreadAloudHelper(rlst: List[Int],count: Int, finallst: List[Int]): List[Int] = {
    if (rlst.isEmpty) { 
      return finallst
    }
    else if (count <= 0){
      if (rlst.tail.tail.isEmpty) {
        return finallst
      }
      unreadAloudHelper(rlst.tail.tail,rlst.tail.tail.head,finallst)
    }
    else {
      unreadAloudHelper(rlst,count-1,rlst.tail.head::finallst)
    }
  }
}
