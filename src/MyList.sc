import scala.annotation.tailrec

abstract class MyAbstractList {
  def len: Int
  def contains(searched: Int): Boolean
}

case class MyEmptyList() extends MyAbstractList {
  override def contains(searched: Int): Boolean = false
  override def len: Int = 0
}

case class MyList(num: Int, tail: MyAbstractList) extends MyAbstractList {
  override def contains(searched: Int): Boolean = num == searched || tail.contains(searched)
  override def len: Int = 1 + tail.len
}


val myList = MyList(1, MyList(2, MyList(3, MyEmptyList())))
myList.contains(2)
myList.contains(5)