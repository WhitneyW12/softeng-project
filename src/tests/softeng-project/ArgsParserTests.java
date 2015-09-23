package softeng-project;
import org.junit.*;
import static org.junit.Assert.*;
public class ArgsParserTests{
	@Before
	public void before()
	{
		ArgsParser ap = new ArgsParser();
		
	}
	
	@Test
	public void ParseStringToFloat(){
		String[] args= new String[3]
		args[0]="7";
		args[1]="2";
		args[2]="5";
		float[] floatargs= new float[3];
		floatargs=ap.parseFloat(args);
		for (int i=0;i<args.length();i++){
			
			//assertEquals( Float.parseFloat(args[i]),floatargs[i])
			assertTrue(false);
		}
		
		
	}
	
	
}
