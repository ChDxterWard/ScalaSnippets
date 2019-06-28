abstract class MyOption[A] {
  def flatMap[B](f: A => MyOption[B]): MyOption[B]
  def map[B](f: A => B): MyOption[B]
}

case class MyNone[A]() extends MyOption[A]  {
  def flatMap[B](f: A => MyOption[B]): MyOption[B] = MyNone()
  def map[B](f: A => B) = MyNone()
}

case class MySome[A](a: A) extends MyOption[A] {
  def flatMap[B](f: A => MyOption[B]): MyOption[B] = f(a)
  def map[B](f: A => B) = MySome(f(a))
}

val a = MySome(3)
val o2 = a.flatMap((x: Int) => MySome(x+1))
MyNone().flatMap((x: Int) => MySome(x+1))
