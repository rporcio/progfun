package streams

object test {

	class TerrainTest extends StringParserTerrain {
		val level =
        """oooo
          |oSoo
          |oooo
          |ooTo""".stripMargin
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(205); 
	
	val t = new TerrainTest();System.out.println("""t  : streams.test.TerrainTest = """ + $show(t ));$skip(9); val res$0 = 
	t.level;System.out.println("""res0: String = """ + $show(res$0));$skip(12); val res$1 = 
	t.startPos;System.out.println("""res1: streams.test.t.Pos = """ + $show(res$1));$skip(8); val res$2 = 
	t.goal;System.out.println("""res2: streams.test.t.Pos = """ + $show(res$2));$skip(9); val res$3 = 
	
	"asd";System.out.println("""res3: String("asd") = """ + $show(res$3))}
	
}
