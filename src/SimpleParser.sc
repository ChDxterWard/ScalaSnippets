case class SimpleParser(in: List[Char]) {
  def accepts(): Boolean =  parse(in ::: List('#')) == List('#')
  def isNext(c: Char, lst: List[Char]): Boolean = lst match {
    case Nil => false
    case h::_ => h == c
  }
  def myMatch(c: Char, lst: List[Char]): List[Char] = lst match {
    case Nil => Nil
    case h::t => {
      if (h == c)
        t
      else
        Nil
    }
  }
  def parse(lst: List[Char]): List[Char] = {
    if (isNext('a', lst)) {
      val o1 = myMatch('a', lst)
      val o2 = parse(o1)
      myMatch('b', o2)
    }
    else {
      lst
    }
  }
}

val s = SimpleParser(List('a', 'b'))
s.accepts()

