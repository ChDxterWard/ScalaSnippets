import scala.annotation.tailrec

@tailrec
def qs(in: List[Double]): List[Double] = in match {
  case Nil => Nil
  case h::t => {
    val lList = qs(t.filter(x => x < h))
    val rList = qs(t.filter(x => x > h))
    lList ::: List(h) ::: rList
  }
}

def qs2(in: List[Double]): List[Double] = in match {
  case Nil => Nil
  case h::t => {
    val (lList, rList) = t.partition(x => x < h)
    qs2(lList) ::: List(h) ::: qs2(rList)
  }
}