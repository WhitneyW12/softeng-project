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
	@Test
	public void checkArgumentValues()
	{
		ap.addArgumentName("length");
		ap.addArgumentName("width");
		ap.addArgumentName("heigth");
		ap.setValue("length","7");
		ap.setValue("width","5");
		ap.setValue("heigth","2");
		assertEquals("7", ap.getArgumentValue("length"));
		assertEquals("5", ap.getArgumentValue("width"));
		assertEquals("2", ap.getArgumentValue("heigth"));
		
	}
	
	@Test 
	public void checkArgumentDescription(){
		ap.addArgumentName("length");
		ap.addArgumentName("width");
		ap.addArgumentName("heigth");
		ap.addDescription("length","the length of the box");
		ap.addDescription("width","the width of the box");
		ap.addDescription("heigth","the heigth of the box");
		assertEquals("the length of the box", ap.getDescription("length"));
		assertEquals("the width of the box", ap.getDescription("width"));
		assertEquals("the heigth of the box", ap.getDescription("heigth"));
		
	}
	@Test
	public void checkIfDashHPrintsTheDescriptions()
	{
		ap.addArgumentName("length");
		ap.addArgumentName("width");
		ap.addArgumentName("heigth");
		ap.addDescription("length","the length of the box");
		ap.addDescription("width","the width of the box");
		ap.addDescription("heigth","the heigth of the box");
		assertEquals("length the length of the box\n width the width of the box\n heigth the heigth of the box\n ",
					ap.getHelpText());
		
		
	}
	@Test
	
	
	//@Test
	public void checkIfArgsParserGetsArgs(){
		
	}
	
	//@Test
	public void parseStringToFloat(){		
		
	}

	
}
