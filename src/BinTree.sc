sealed abstract class AbstractTree() {
  def find(ele: Double): Boolean
}

case class EmptyTree() extends AbstractTree {
  override def find(ele: Double): Boolean = false
}

case class MyTree(curr: Double, l: AbstractTree, r: AbstractTree) extends AbstractTree {
  override def find(ele: Double): Boolean = if (curr == ele) true else if (curr < ele) r.find(ele) else l.find(ele)
}

val t = MyTree(5,
  MyTree(3,
    MyTree(1, EmptyTree(), EmptyTree()),
    MyTree(2, EmptyTree(), EmptyTree())
  ),
  MyTree(7,
    MyTree(24, EmptyTree(), EmptyTree()),
    MyTree(39, EmptyTree(), EmptyTree()))
)

t.find(5) // t
t.find(39) // t
t.find(2944) // f


// Globale Lösung
def find(t: AbstractTree, ele: Double): Boolean = t match {
  case emptyTree: EmptyTree => false
  case myTree: MyTree => if (ele == myTree.curr) true else if (myTree.curr > ele) find(myTree.l, ele) else find(myTree.r, ele)
}

find(t, 5) // t
find(t, 39) // t
find(t, 2944) // f