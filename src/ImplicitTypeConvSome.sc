implicit class StringInc(in: String) {
  def inc: String = in.map(x => (x.toInt + 1).toChar)
}

/*

implicit class NewOption(val op1: Option[Double]) {
  def bind(f: Option[Double] => NewOption): NewOption = f(op1)
  def sqrt: Double = Math.sqrt(op1.getOrElse(0.0))
 */

implicit class MyOption(in: Option[Double]) {
  def bind(f: Option[Double] => Option[Double]): Option[Double] = f(in)
  def sqrt: Double = Math.sqrt(in.getOrElse(0.0))
}

val s: String = "abc"
s.inc