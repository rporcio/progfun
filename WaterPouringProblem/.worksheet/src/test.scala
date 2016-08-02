object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(64); 

	val problem = new Pouring(Vector(4, 7, 2, 1, 8));System.out.println("""problem  : Pouring = """ + $show(problem ));$skip(22); val res$0 = 
  problem.solution(6);System.out.println("""res0: Stream[test.problem.Path] = """ + $show(res$0))}

}
