import scala.collection.Seq
import scala.collection.immutable.StringOps
import scala.annotation.tailrec

object nazwa {

  def leq[A](q:A,w:A)(implicit ev: A => Ordered[A]) : Boolean ={
    if (q>w) true
    else false
  }

  def isOrdered[A](seq: Seq[A])(leq: (A, A) => Boolean): Boolean ={
    def isOrdered2[A](seq: Seq[A])(leq: (A, A) => Boolean): Boolean = {
      if (seq.tail.isEmpty) true
      else if (leq(seq.head, seq.tail.head)) false
      else isOrdered2(seq.tail)(leq)
    }
    isOrdered2(seq)(leq)
  }

  def insertInto[A](a: A, seq: Seq[A])(leq: (A, A) => Boolean): Seq[A] = {
    def insertInto2[A](a: A, seq: Seq[A],n:Int)(leq: (A, A) => Boolean): Seq[A] = {
      if(n==0) {
        if (seq.tail.isEmpty) {
          if (!leq(a, seq.head)) Seq(a) ++ Seq(seq.head)
          else Seq(seq.head) ++ Seq(a)
        }
        else if (!leq(a, seq.head)) Seq(a) ++ insertInto2(a, seq, 1)(leq)
        else Seq(seq.head) ++ insertInto2(a, seq.tail, 0)(leq)
      }
      else{
        if (seq.tail.isEmpty) {
          Seq(seq.head)
        }
        else
          Seq(seq.head) ++ insertInto2(a, seq.tail, 1)(leq)
      }

    }
    insertInto2(a,seq,0)(leq)
  }

  def compress[Char](seq: Seq[Char]): Seq[(Char, Int)] = {

      def compress2[A](seq: Seq[A] , n:Int): Seq[(A, Int)] = {
        if (seq.tail.isEmpty) Seq((seq.head, n))
        else if (seq.head==seq.tail.head)  compress2(seq.tail,n+1)
        else Seq((seq.head,n))++compress2(seq.tail,1)
      }
    compress2(seq,1)
  }
  def deStutter[A](seq: Seq[A]): Seq[A] = {
    if (seq.tail.isEmpty) Seq(seq.head)
    else if (seq.head==seq.tail.head)  deStutter(seq.tail)
    else Seq(seq.head)++deStutter(seq.tail)
  }

  def main(args: Array[String]) {
    val seq1: Seq[Char] = Seq('a', 'a', 'b', 'c', 'c', 'c', 'a', 'a', 'b', 'd')
    val seq2: Seq[Char] = Seq('1', '1', '2', '3', '3', '3', '1', '1', '2', '4')
    val seq3: Seq[Char] = Seq('a', 'a', 'b', 'c', 'c', 'c', 'd', 'd', 'd', 'd')
    val seq4: Seq[Char] = Seq('1', '1', '2', '3', '3', '3', '4', '4', '4', '4')
    println(compress(seq1))
    println(deStutter(seq1))
    println(compress(seq2))
    println(deStutter(seq2))
    println(isOrdered(seq1)(leq))
    println(isOrdered(seq2)(leq))
    println(isOrdered(seq3)(leq))
    println(isOrdered(seq4)(leq))
    println(insertInto('z',seq3)(leq))
    println(insertInto('b',seq3)(leq))
  }
}
