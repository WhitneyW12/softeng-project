package edu.jsu.mcis;
import org.junit.*;
import static org.junit.Assert.*;
public class ArgsParserTests{
	private ArgsParser ap;

	@Before
	public void setup()
	{
		ap = new ArgsParser();		
	}
	
	@Test 
	public void checkArgumentNames()
	{
		ap.addArgumentName("length");
		ap.addArgumentName("width");
		ap.addArgumentName("heigth");
		assertEquals("", ap.getArgumentValue("length"));
		assertEquals("", ap.getArgumentValue("width"));
		assertEquals("", ap.getArgumentValue("heigth"));		
	}
	//@Test
	public void checkIfArgsParserGetsArgs(){
		
	}
	
	//@Test
	public void parseStringToFloat(){		
		
	}

	
}
