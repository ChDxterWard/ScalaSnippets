val lst = List((1, "a"), (2, "b"), (3, "b"), (4, "c"), (5, "d"))
val erg1 = for (e <- lst) yield e._2
val erg2 = for (e <- lst if (e._1 % 2 == 0)) yield e._1
