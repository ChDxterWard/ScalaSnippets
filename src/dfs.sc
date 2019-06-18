

def dfs(in: Array[List[Int]], goal: Int => Boolean, start: Int): List[Int] = {
  def myDfs(path: List[Int]): List[Int] = path match {
    case Nil => Nil
    case h::_ => {
      if (goal(h)) path.reverse
      else {
        // Entferne alle bereits besuchten Knoten.
        val nodes = in(h).filter(ele => !path.contains(ele))
        // Ich möchte das wirklich zuerst nur der headt ausgearbeitet wird(wichtig für dfs)
        // deshalb toStream
        val ret = nodes.toStream.map(node => myDfs(node::path))
        ret.find(ele => ele != Nil).getOrElse(Nil)
      }
    }

  }
  myDfs(List(start))
}

val adj = Array(
  List(1, 2),
  List(0, 2, 3),
  List(0, 1) ,
  List(1)
)

dfs(adj, x => x == 3, 0)

