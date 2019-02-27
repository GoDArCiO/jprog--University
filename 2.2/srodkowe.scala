object Main {
  def main(args: Array[String]) {
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

    while(i<n1.length() || i<n2.length()){
      if (i>n1.length()-1){
        var l2 = n2(i).asDigit
        sum = l2 + r
      }
      else if (i>n2.length()-1){
        var l1 = n1(i).asDigit
        sum = l1 + r
      }
      else {
        var l1 = n1(i).asDigit
        var l2 = n2(i).asDigit
        sum = l1 + l2 + r
      }
      if (sum>9){
        r = sum/10
        sum = sum%10
        wynik = wynik + sum
        println(wynik)

      }
      else{
        r = 0
        wynik = wynik + sum
        println(wynik)
      }
      i=i+1
    }
    print("finalny wynik -> ")
    print(wynik.reverse)
  }
}