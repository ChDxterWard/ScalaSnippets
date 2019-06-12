import scala.annotation.tailrec
// Streams sind ähnlich Listen, mit den unterschied das ihre Tails lazy (also nur bei Anforderung) ausgewertet werden.

// Definieren eines Streams
val s1 = Stream(1, Stream(2, Stream(3, Stream.Empty)))
val s2 = 1 #:: 2 #:: 3 #:: Stream.Empty

// Definieren eine Funktion, die einen Stream im bereich von start und end definiert
def streamRange(start: Int, end: Int): Stream[Int] = {
  if (start == end) {
    Stream.cons(start, Stream.empty)
  }
  else {
    //Stream.cons(start, streamRange(start + 1, end))
    start #:: streamRange(start + 1, end)
  }
}
val s3 = streamRange(1, 3)
// die h #:: t Schreibweise lässt sich auch in switch cases benutzen
def myStreamPrint(s: Stream[Int]): Unit = {
  s match {
    case h #:: t => {
      println(h)
      myStreamPrint(t)
    }
    case h #:: _ => {
      println(h)

    }
    case _ => {
      println("Ende")
    }
  }
}
//myStreamPrint(s3)

