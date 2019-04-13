object programix {

  //zad1
  def napsort(): Unit = {
    println("Podaj ilosc wyrazow")
    var n = io.StdIn.readInt()
    var lista = new Array[String](n)
    var i = 0
    while (i < n) {
      println("Podaj wyraz")
      lista(i) = io.StdIn.readLine()
      i = i + 1
    }
    lista = lista.sortWith(_.length < _.length)
    print("nieposortowane ")
    println(lista.mkString(","))
    i = 0
    var p = 0
    for (i <- 0 to n - 1) {
      for (p <- 0 to n - 2) {
        if (lista(p).length() == lista(p + 1).length() && lista(p) > lista(p + 1)) {
          var temp = lista(p)
          lista(p) = lista(p + 1)
          lista(p + 1) = temp
        }
      }
    }
    print("posortowane ")
    println(lista.mkString(","))
  }
  //koniec zad1

  //zad2
  def dodaj(): Unit = {
    println("Podaj pierwsza liczbe")
    var n1 = io.StdIn.readLine()
    println("Podaj druga liczbe")
    var n2 = io.StdIn.readLine()
    n1 = n1.reverse
    n2 = n2.reverse
    var wynik = ""
    var sum = 0
    var r = 0
    var i = 0
    while (i < n1.length() || i < n2.length()) {
      i match {
        case z if i > n1.length() - 1 => {
          var l2 = n2(i).asDigit
          sum = l2 + r
        }
        case z if i > n2.length() - 1 => {
          var l1 = n1(i).asDigit
          sum = l1 + r
        }
        case _ => {
          var l1 = n1(i).asDigit
          var l2 = n2(i).asDigit
          sum = l1 + l2 + r
        }
      }
      sum match {
        case z if sum > 9 => {
          r = sum / 10
          sum = sum % 10
          wynik = wynik + sum
          println(wynik)
        }
        case _ => {
          r = 0
          wynik = wynik + sum
          println(wynik)
        }
      }
      i = i + 1
    }
    print("finalny wynik -> ")
    print(wynik.reverse)
  }
  //koniec zad2

  //zad3
  def zakoduj(): Unit = {
    var szyfrownik = Array.ofDim[Char](26, 26)
    val alphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".toArray
    var i = 0
    var o = 0
    for (i <- 0 to 25) { //tworze szyfrownik
      for (o <- 0 to 25) {
        szyfrownik(i)(o) = alphabet(o + i)
      }
    }
    for (i <- 0 to 25) { //wyswietlam szyfrownik
      for (o <- 0 to 25) {
        printf("%c", szyfrownik(i)(o))
      }
      printf("\n")
    }
    println("podaj tekst do zaszyfrowania")
    var tekst = io.StdIn.readLine()
    println("podaj klucz")
    var klucz = io.StdIn.readLine()
    tekst = tekst.replaceAll(" ", "") //usuwam białe znaki
    println(tekst)
    println(klucz)
    val tekarr = tekst.toCharArray
    val kluarr = klucz.toCharArray
    val tl = tekarr.length
    val kl = kluarr.length
    var i1 = 0
    var i2 = 0
    var o1 = 0
    while (tl > i2) { //szyfruje
      for (i1 <- 0 to 25) {
        if (szyfrownik(i1)(0) == tekarr(i2)) {
          for (o1 <- 0 to 25) {
            if (szyfrownik(0)(o1) == kluarr(i2 % kl)) {
              printf("%c", szyfrownik(i1)(o1))
            }
          }
        }
      }
      i2 = i2 + 1
    }
    printf("\n")
  }
  //koniec zad3

  def main(args: Array[String]) {
    //menu
    println("wybierz zadanie")
    println("1-> Pobiera całkowitą n, pobiera n napisów, sortuje napisy")
    println("2-> Dodaj pisemnie dwie wielkie liczby")
    println("3-> Pobiera słowo, klucz i szyfruje według niego")
    val c = io.StdIn.readInt()
    //koniec menu

    c match {
      //zad1
      case 1 => napsort()
      //zad2
      case 2 => dodaj()
      //zad3
      case 3 => zakoduj()
      //zad?
      case _ => println("nie mam takiego zadania")
    }
    //koniec match
  }
}
