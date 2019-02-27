object Main {
  def main(args: Array[String]) {
    println("Podaj ilosc wyrazow")
    var n = io.StdIn.readInt()
    var lista = new Array[String](n)
    var i = 0
    while (i<n){
      println("Podaj wyraz")
      lista(i) = io.StdIn.readLine()
      i=i+1
    }
    lista = lista.sortWith(_.length < _.length)
    print("nieposortowane ")
    println(lista.mkString(","))
    i = 0
    var p = 0
    for( i <- 0 to n-1){
      for( p <- 0 to n-2){
        if(lista(p).length()==lista(p+1).length() && lista(p)>lista(p+1)){
          var temp = lista(p)
          lista(p) = lista(p+1)
          lista(p+1) = temp

        }
      }
    }
    print("posortowane ")
    println(lista.mkString(","))
  }
}