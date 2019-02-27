object Main {
 def main(args: Array[String]) {
var a = io.StdIn.readInt()
var b =a/2
var c =b+1

while(b+c!=a){
    Thread.sleep(1000)
while(pierwsza(b)){//b nie jest pierwsza
b -= 1
println(b)
while(pierwsza(c)){//c nie jest pierwsza
c += 1
println(c)
}
if((b+c)==a && !(pierwsza(b)) && !(pierwsza(c))){

        println("wygrana")
println(c)
println(b)
println(c)
        Thread.sleep(1000000)
}

}
if((b+c)==a && !(pierwsza(b)) && !(pierwsza(c))){

        println("wygrana")
println(c)
println(b)
println(c)
        Thread.sleep(1000000)
}

if(!(pierwsza(b))){
    b -=1
}
if(!(pierwsza(c))){
    c +=1
}
}
println(b)
println(c)
 }
def pierwsza( n:Int ) : Boolean = {
var i=2
while(i*i<=n){
		if(n%i==0)
			return true //gdy znajdziemy dzielnik, to dana liczba nie jest pierwsza
    i += 1
}
	return false
}
}

