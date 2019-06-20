/**
  * Variablen o1 und o2 sollen verschieden.
  * Am besten mit Monaden (und damit mit bind/flatmap)
  */

case class MyMonad(in: List[Char]) {
  def myBind(f: List[Char] => MyMonad): MyMonad = f(in)
}

object SimpleParser {
  def accepts(in: List[Char]): Boolean = ('#' :: parse(in).in).reverse == List('#')
  def isNext(lst: List[Char])(c: Char): Boolean = {
    lst match {
      case Nil => false
      case h::_ => h == c
    }
  }

  def matchC(c: Char)(lst: List[Char]): MyMonad = MyMonad(lst match {
    case Nil => Nil
    case h::t =>
      if (h == c) t
      else Nil
  })

  def matchA(lst: List[Char]): MyMonad = matchC('a')(lst)
  def matchB(lst: List[Char]): MyMonad = matchC('b')(lst)

  def parse(in: List[Char]): MyMonad = {
    val m = MyMonad(in)
    if (isNext(in)('a')) {
      m.myBind(matchA).myBind(parse).myBind(matchB)
    }
    else {
      m
    }
  }
}

val in1 = List('a', 'a', 'b', 'b')
println(SimpleParser.accepts(in1))

