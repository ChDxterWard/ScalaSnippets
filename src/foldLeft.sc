val l = List[Double](1, 2, 3, 4, 0, 5)

def len[A](in: List[A]): Int = {
  in.foldLeft(0)((x, _) => x + 1)
}

def sum(in: List[Double]): Double = in match {
  case Nil => .0
  case h::t => t.foldLeft(h)((x, y) => x + y)
}

def min(in: List[Double]): Option[Double] = in match {
  case Nil => None
  case h::t => Some(t.foldLeft(h)((x, y) => if (x > y) y else x))
}

def max(in: List[Double]): Option[Double] = in match {
  case Nil => None
  case h::t => Some(t.foldLeft(h)((x, y) => if (x < y) y else x))
}

def mean(in: List[Double]): Double = sum(in) / len(in)


def minmax(in: List[Double])(cmp: => (Double, Double) => Double): Option[Double] = in match {
  case Nil => None
  case h::t => Some(t.foldLeft(h)(cmp))
}

def _min(in: List[Double]): Option[Double] = minmax(in)((x,y) => if (x < y) x else y)
def _max(in: List[Double]): Option[Double] = minmax(in)((x,y) => if (x > y) x else y)

def __plus(a: Option[Double], b: Option[Double]): Option[Double] = (a, b) match {
  case (Some(x), Some(y)) => Some(x+y)
  case _ => None
}

def __mean(in: List[Option[Double]]) = in match {
  case Nil => Some(.0)
  case h::t => {
    Some(t.foldLeft(h)(__plus).getOrElse(.0) / in.length)
  }
}



mean(l) // 2.5
__mean(l.map(x => Some(x))) // 2.5
min(l).getOrElse(Double.NaN) // 0
max(l).getOrElse(Double.NaN) // 5
_min(l).getOrElse(Double.NaN) // 0
_max(l).getOrElse(Double.NaN) // 5
_max(Nil).getOrElse(Double.NaN) // Double.Nan
