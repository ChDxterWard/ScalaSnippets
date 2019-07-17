def linSearch(in: List[Double], ele: Double): Boolean = in match {
  case Nil => false
  case h::t => h == ele || linSearch(t, ele)
}

linSearch(List(1, 2, 33, -2, 44), 2) // true
linSearch(List(1, 2, 33, -2, 44), 3) // false