object test {

	val problem = new Pouring(Vector(4, 7, 2, 1, 8))
                                                  //> problem  : Pouring = Pouring@337d0578
  problem.solution(6)                             //> res0: Stream[test.problem.Path] = Stream(Fill(4) Pour(4,2) --> Vector(0, 0, 2
                                                  //| , 0, 6), ?)

}