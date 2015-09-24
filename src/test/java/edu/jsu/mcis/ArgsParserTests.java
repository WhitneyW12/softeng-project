package edu.jsu.mcis;
import org.junit.*;
import static org.junit.Assert.*;
public class ArgsParserTests{
	private ArgsParser ap;
	private String args[];
	@Before
	public void before()
	{    args = new String[3];
		args[0]="7";
		args[1]="5";
		args[2]="2";
		 ap = new ArgsParser(args);
		
	}
	
	@Test
	public void ParseStringToFloat(){
		
		float[] floatargs= new float[3];
		//floatargs = ap.parseFloat(args);
		for (int i=0;i<args.length;i++){
			
			assertEquals( Float.parseFloat(args[i]),floatargs[i]);
			
		}
		
		
	}
	
	
}
