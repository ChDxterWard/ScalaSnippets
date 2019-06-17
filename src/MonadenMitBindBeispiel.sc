/**
Übung:

  Herausfinden welchen Aktienkurs die Firma hat bei der Peter Müller angestelllt ist.

  Quellcode vereinfachen mit Monaden und Bind

  p = getPerson("Peter Müller")
  if (p != None)
    e = getEmployer(p)
  else
    e = None
  if (e != None)
    i = getISIN(e)
  else
    i = None
  if (i != None)
    q = getQuote(i)
  else
    q = None

  Lösung: Nutzen von Options.
  Options sind Monaden die bereits das bind als flatmap implementiert haben.
  None.flatmap(f) liefert immer None zurück.

  getPerson("Peter Müller").flatmap(getEmployer).flatmap(getISIN).flatmap(getQuote)
  */

def getPerson(name: String): Option[String] = {
  // Simuliere DB Suche
  if (name == "Peter Müller")
    Some("Peter Müller")
  else
    None
}

def getEmployer(name: String): Option[String] = {
  // Simuliere DB Suche
  if (name == "Peter Müller")
    Some("IBM")
  else
    None
}

def getISIN(firmenname: String): Option[Int] = {
  // Simuliere DB Suche
  if (firmenname == "IBM")
    Some(123)
  else
    None
}

def getQuote(isinNr: Int): Option[Double] = {
  // Simuliere DB Suche
  if (isinNr == 123)
    Some(401333.22)
  else
    None
}


getPerson("Peter Müller").flatMap(getEmployer).flatMap(getISIN).flatMap(getQuote)
getPerson("Hans Schmitz").flatMap(getEmployer).flatMap(getISIN).flatMap(getQuote)