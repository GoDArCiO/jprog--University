
object Main2 {

  //zad1
  def odwroc(str: String): String = {
    def odwroc2(str: String,n: Int,ret: String): String = {
      n match{
        case 0 => ret
        case _ => odwroc2(str,n-1,ret+str(n-1))
      }
    }
    odwroc2(str,str.length,"")
  }
//koniec zad1

  //zad2
  def palindrom(tab: Array[Int]): Boolean ={
    def palindrom2(tab: Array[Int],f:Int,l:Int): Boolean ={
f match {
  case z if l<=f => true
  case z if tab(f)==tab(l) => palindrom2(tab,f+1,l-1)
  case _ => false
}
    }
    palindrom2(tab,0,tab.length-1)
  }
//koniec zad2

  //zad3
  def policz(str: String): Int ={
    def policz2(str: String,n:Int,cel:Int): Int = {
      n match{
        case z if str.length == n => cel
        case z if str(n).isUpper => policz2(str,n+1,cel)
        case z if str(n).isLower => policz2(str,n+1,cel+1)
      }
    }
    policz2(str,0,0)
  }
  //koniec zad3

  //zad4
  def pierwsza(n: Int): Boolean ={
    def pierwsza2(n: Int,m:Int): Boolean ={
      n match{
        case z if m <2 => true
        case z if n%m==0 => false
        case _ => pierwsza2(n,m-1)
      }
    }
    pierwsza2(n,n/2)
  }
  //koniec zad4

  //zad5
  def ciag(n: Int): Int ={
    def ciag2(q: Int,w:Int,e:Int,r:Int): Int ={
      r match{
        case z if r==0 => e
        case z if q<=w => ciag2(q+w,w,q+w,r-1)
        case z if w<q => ciag2(q,q+w,q+w,r-1)
      }
    }
    n match{
      case 1 => 1
      case 2 => 1
      case _ => ciag2(1,1,0,n-2)
    }
  }
  //koniec zad5

  //zad6
  def trojkat(n: Int): Unit = {
    def printTriangleAux(n: Int, values: Array[Int] = Array(1)): Unit = {
      if(values.length <= n) {
        printRow(values)
        println()
        printTriangleAux(n, recalculate(values) :+ 1)
      }
    }
    printTriangleAux(n)
  }

  def printRow(values: Array[Int]): Unit = {
    if(values.length != 0) {
      print(values.head)
      if(values.length != 1) print("   ")
      printRow(values.tail)
    }
  }

  def recalculate(values: Array[Int]): Array[Int] = {
    val temp = new Array[Int](values.length)
    temp(0) = 1
    var i = 1
    while(i < temp.length) {
      temp(i) = values(i) + values(i-1)
      i += 1
    }
    temp //return
  }
  //koniec zad6

  //binarne
  def toBinary(n: Int): String = {
    def binary(acc: String, n: Int): String = {
      n match {
        case 0 | 1 => n+acc
        case _ => binary((n%2)+acc,n/2)
      }
    }
    binary("",n)
  }
  //koniec binarnego

  def main(args: Array[String]) {
    //menu
    println("wybierz zadanie")
    println("1-> Odwraca string")
    println("2-> Zwraca info czy palindrom")
    println("3-> Liczy ile słowo ma małych liter")
    println("4-> wypisuje czy pierwsza")
    println("5-> fibon")
    println("6-> wyswietla trojkat o smiesznej wysokosci")
    println("7-> bonus konwerter int->bin")
    val c = io.StdIn.readInt()
    //koniec menu

    c match {
      //zad1
      case 1 => println(odwroc("elo"))
      //zad2
      case 2 => {
        var arr1 = Array(1,2,3)
        var arr2 = Array(1,2,1)
        var arr3 = Array(1,2,2,1)
        var arr4 = Array(1,2,1,2)
        println(palindrom(arr1))
        println(palindrom(arr2))
        println(palindrom(arr3))
        println(palindrom(arr4))
      }
      //zad3
      case 3 =>
        println(policz("ooOOooOO"))
        println(policz("OOooOOooo"))
        println(policz("KUPA"))
        println(policz("siku"))
      //zad4
      case 4 =>
        println(pierwsza(13))
        println(pierwsza(22))
      //zad5
      case 5 =>
        println(ciag(1))
        println(ciag(2))
        println(ciag(3))
        println(ciag(4))
        println(ciag(5))
      //zad6
      case 6 => trojkat(5)
        //bonus
      case 7 => println(toBinary(6))
      //zad?
      case _ => println("nie mam takiego zadania")
    }
    //koniec match
  }
}
