import scala.annotation.tailrec

def myLength[A](in: List[A]): Int = in match {
  case Nil => 0
  case _::t => 1 + myLength(t)
}

def myMyLength[A](lst: List[A]): Int = {
  @tailrec
  def myLength2[A](in: List[A], acc: Int): Int = in match {
    case Nil => acc
    case _::t => myLength2(t, acc + 1)
  }
  myLength2(lst, 0)
}


myLength(List(1, 2, 3, 4, 5))
myMyLength(List(1, 2, 3, 4, 5))