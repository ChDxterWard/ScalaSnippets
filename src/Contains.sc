import scala.annotation.tailrec

@tailrec
def contains[A](in: List[A], ele: A): Boolean = in match {
  case Nil => false
  case h::t => h == ele || contains(t, ele)
}