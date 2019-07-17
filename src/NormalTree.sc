sealed abstract class AbstractTree() {
  def dfs(in: Double): Boolean
  def bfs(in: Double): Boolean
}

case class EmptyTree() extends  AbstractTree {
  override def dfs(in: Double): Boolean = false
  override def bfs(in: Double): Boolean = false
}

case class MyTree(curr: Double, l: AbstractTree, r: AbstractTree) extends AbstractTree {
  override def dfs(in: Double): Boolean = curr == in || l.dfs(in) || r.dfs(in)
  override def bfs(in: Double): Boolean = curr == in || r.dfs(in) || l.dfs(in)
}


val t = MyTree(2,
  MyTree(1,
    MyTree(4,
      EmptyTree(),
      EmptyTree()),
    MyTree(5,
      EmptyTree(),
      EmptyTree())),
  MyTree(22,
    EmptyTree(),
    EmptyTree()))

t.dfs(2) // t
t.dfs(22) // t
t.dfs(4) // t
t.dfs(2777) // f
t.bfs(2) // t
t.bfs(22) // t
t.bfs(4) // t
t.bfs(2777) // f
