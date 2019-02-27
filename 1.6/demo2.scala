import scala.math.sqrt
object Main {
  def isPrime(x : Int) : Boolean = {
    var n = 2
    while(n<= sqrt(x)){
      if(x%n==0){
        return false
      }
      n+=1
    }
    true
  }
  def main(args: Array[String]) {
    println("Podaj parzysta liczbe")
    var number = io.StdIn.readInt()
    var a = 3
    var b = number - 3
    while(!(isPrime(a) && isPrime(b))) {
      a=a+2
      b=b-2
    }
    println(a)
    println(b)
  }
}