case class Monad[A](in: A) {
  def bind[B](f: A => Monad[B]): Monad[B] = f(in)
}


case object Parser {
  def accepts(in: List[Char]): Boolean = parse(in ::: List('#')).in  == List('#')
  def matchC(in: List[Char])(c: Char): Monad[List[Char]] = {
    in match {
      case Nil => Monad(Nil)
      case h::t => if (h == c) Monad(t) else Monad(Nil)
    }
  }
  def matchA(in: List[Char]): Monad[List[Char]] = matchC(in)('a')
  def matchB(in: List[Char]): Monad[List[Char]] = matchC(in)('b')
  def isNext(c: Char, in: List[Char]): Boolean = in match {
    case Nil => false
    case h::_ => h == c
  }
  def parse(in: List[Char]): Monad[List[Char]] = {
    val m = Monad(in)
    if (isNext('a', in)) {
      m.bind(matchA).bind(parse).bind(matchB)
    }
    else {
      m
    }
  }
}






val in1 = List('a', 'a', 'b', 'b')
val in2 = List('a', 'b', 'b')
val in3 = List('a', 'a', 'a', 'b', 'b')
println(Parser.accepts(in1))
println(Parser.accepts(in2))
println(Parser.accepts(in3))
