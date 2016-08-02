package quickcheck

import common._

import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  val em: Gen[H] = empty

  lazy val genHeap: Gen[H] = for {
    i <- Gen.choose(0, Int.MaxValue)
    h <- oneOfHeap
  } yield insert(i, h)

  def oneOfHeap: Gen[H] = oneOf(genHeap, em)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

  property("findMin") = forAll { (h: H) =>
    val m = getMin(h)
    findMin(insert(m, h)) == m
  }

  property("findMinInMelded") = forAll { (h1: H, h2: H) =>
    val min = Math.min(getMin(h1), getMin(h2))
    val h = meld(h1, h2)
    getMin(h) == min
  }

  property("findMinAfterDeletion") = forAll { (h: H) =>
    if (isEmpty(h)) 0 != deleteMin(insert(0, insert(1, h)))
    else {
      val min = getMin(h)
      
      val h1 = deleteMin(h)
      val h2 = insert(min, empty)
      val melded = meld(h1, h2)
      
      getMin(melded) == min
      getMin(melded) != getMin(deleteMin(h))
    }
  }

  private def getMin(h: H) = if (isEmpty(h)) -1 else findMin(h)

}
