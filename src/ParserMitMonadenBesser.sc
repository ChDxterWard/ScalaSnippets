case class Monad[A](in: A) {
  def bind(f: A => Monad[A]): Monad[A] = if (in == Nil) this else f(in)
  def orElse(m: Monad[A]): Monad[A] = if (in == Nil) m else this
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
  def parse(in: List[Char]): Monad[List[Char]] = Monad(in)
    .bind(matchA)
    .bind(parse)
    .bind(matchB)
    .orElse(Monad(in))

}






val in1 = List('a', 'a', 'b', 'b')
val in2 = List('a', 'b', 'b')
val in3 = List('a', 'a', 'a', 'b', 'b')
println(Parser.accepts(in1))
println(Parser.accepts(in2))
println(Parser.accepts(in3))
