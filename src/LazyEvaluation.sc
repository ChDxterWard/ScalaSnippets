// Lazy Evaluation
// Syntax: Parameter: => Typ
def foo(x: Int): Double = 10/x

// Wert von x wird hier gelesen wenn gebraucht und sich anschließend gemerkt (Call by need)
// Hilfreich zum Beispiel bei Shortcircuit-Evaluation
//Bsp.:
//  True || x ... x wird nicht ausgewertet da Ausdruck immer wahr
//  False && x ... x wird nicht ausgewertet da Ausdruck immer falsch
def fooLazy(x: => Int): Double = 10/x

// Übung: Programmieren and, or, ifThenElse



