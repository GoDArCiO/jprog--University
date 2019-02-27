
object Main2 {

  def main(args: Array[String]) {
    var szyfrownik = Array.ofDim[Char](26, 26)
    val alphabet = Array('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
    var i = 0
    var o = 0
    for (i <- 0 to 25) {
      for (o <- 0 to 25) {
        szyfrownik(i)(o) = alphabet(o + i)
      }
    }
    for (i <- 0 to 25) {
      for (o <- 0 to 25) {
        printf("%c", szyfrownik(i)(o))
      }
      printf("\n")
    }
    println("podaj tekst do zaszyfrowania")
    var tekst = io.StdIn.readLine()
    println("podaj klucz")
    var klucz = io.StdIn.readLine()
    tekst = tekst.replaceAll(" ", "")
    println(tekst)
    println(klucz)
    val tekarr = tekst.toCharArray
    val kluarr = klucz.toCharArray
    val tl = tekarr.length
    val kl = kluarr.length
    var i1 = 0
    var i2 = 0
    var o1 = 0
    while (tl > i2) {
      for (i1 <- 0 to 25) {
        if (szyfrownik(i1)(0) == tekarr(i2)) {
          for (o1 <- 0 to 25) {
            if (szyfrownik(0)(o1) == kluarr(i2%kl)) {
              printf("%c", szyfrownik(i1)(o1))
            }
          }
        }
      }
      i2=i2+1
    }
    printf("\n")
  }
}