val adj = Array(
  List(1, 2),
  List(0, 2),
  List(0, 1)
)

def dfs(in: Array[List[Int]], start: Int, goal: Int => Boolean): List[Int] = {
  def dfs1(path: List[Int]): List[Int] = path match {
    case Nil => Nil
    case h::_ => {
      if (goal(h))
        path.reverse
      else {
        // Filtere besuchte Knoten raus
        val a = in(h).filter(e => !path.contains(e))
        // to.Stream wichtig, da sonst keine echte Tiefensuche
        val ps = a.toStream.map(v => dfs1(v::path))
        ps.find(p => p != Nil).getOrElse(Nil)
      }
    }
  }
}