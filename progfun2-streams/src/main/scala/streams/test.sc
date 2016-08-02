package streams

object test {

	class TerrainTest extends StringParserTerrain {
		val level =
        """oooo
          |oSoo
          |oooo
          |ooTo""".stripMargin
	}
	
	val t = new TerrainTest()                 //> t  : streams.test.TerrainTest = streams.test$TerrainTest@3d24753a
	t.level                                   //> res0: String = oooo
                                                  //| oSoo
                                                  //| oooo
                                                  //| ooTo
	t.startPos                                //> res1: streams.test.t.Pos = Pos(1,1)
	t.goal                                    //> res2: streams.test.t.Pos = Pos(3,2)
	
	"asd"                                     //> res3: String("asd") = asd
	
}