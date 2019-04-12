object programix {

  //zad 2
  def mod2(n:Int): Boolean = {
    val x=n%2
    x match {
      case 0 => {
        true
      }
      case _ => {
        false
      }
    }
  }
  //koniec zad2

  //zad 3
  def count(): Unit = {
    println("podaj pierwszą całkowitą, 0 aby zakończyć")
    var x = io.StdIn.readInt()
    var p=0
    var m=0
    while (x!=0) {
      x match {
        case z if x > 0 => p = p + 1
        case z if x < 0 => m = m + 1
      }
          println("podaj kolejną całkowitą, 0 aby zakończyć")
          x = io.StdIn.readInt()
      }
    println("dodatnich "+p+" ujemnych "+m)
  }
  //koniec zad3

    //zad 4
    def nwd(q:Int,w:Int): Int = {
      var n= Math.abs(q-w)
      while(q%n!=0&&w%n!=0){
      n=n-1
    }
      n
    }
    //koniec zad4

    //zad 5
    def pierwsza(q:Int): Boolean = {
      var n=q/2
      while(q%n!=0){
        n=n-1
      }
      n match {
        case 1 => true
        case _ => false
      }
    }
  //koniec zad5

  //zad 6
  def skladniki(q:Int): (Int,Int) = {
    var n= 2
    var n2=q-n
    while(n2>n&&(!(pierwsza(n)&&pierwsza(n2)))){
      n=n+1
      n2=n2-1
    }
    (n,n2)
  }
  //koniec zad6


  def main(args: Array[String]): Unit = {

    //menu
    println("wybierz zadanie")
    println("2-> Pobiera całkowitą i informuje czy parzysta")
    println("3-> Pobiera całkowite, aż otrzyma 0 i informuje ile dodatnich i ujemnych")
    println("4-> Pobiera dwie całkowite i zwraca nwd")
    println("5-> Pobiera naturalną i sprawdza czy jest pierwsza")
    println("6-> Pobiera naturalną parzystą i wyświetla pierwsze z których się składa")
    val c = io.StdIn.readInt()
    //koniec menu

    c match {
        //zad2
      case 2 => {
        println("Podaj całkowitą")
        val n = io.StdIn.readInt()
        if(mod2(n)){println("parzysta")}
        else{println("nieparzysta")}
      }
        //zad3
      case 3 => {   count()
      }
        //zad4
      case 4 => {
        println("podaj dwie liczby do NWD")
        val n1=io.StdIn.readInt()
        val n2=io.StdIn.readInt()
        println("ich nwd to "+nwd(n1,n2))
      }
        //zad5
      case 5 => {
        println("podaj naturalną")
        val n3=io.StdIn.readInt()
        println(pierwsza(n3))
      }
        //zad6
      case 6 => {
        println("podaj naturalną parzystą")
        val n3=io.StdIn.readInt()
        println(skladniki(n3))
      }
        //zad?
      case _ => {
        println("nie mam takiego zadania")
      }
    }
    //koniec match
  }
}
