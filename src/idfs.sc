def idfs(in: Array[List[Int]], goal: Int => Boolean, start: Int, threshold: Int): List[Int] = {
  def myIdfs(path: List[Int], step: Int): List[Int] = path match {
    case Nil => Nil
    case h::_ => {
      if (goal(h)) path.reverse
      else {
        if (step <= 0) Nil
        else {
          val nodes = in(h).filter(ele => !path.contains(ele))
          val ret = nodes.toStream.map(ele => myIdfs(ele::path, step - 1))
          ret.find(ele => ele != None).getOrElse(None)
        }
      }
    }
  }
  myIdfs(List(start), threshold)
}

val adj = Array(
  List(1, 2),
  List(0, 2),
  List(0, 1)
)

idfs(adj, x => x == 2, 0, threshold = 20)