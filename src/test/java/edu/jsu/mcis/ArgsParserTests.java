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
		ap.addArgument("length","the length of the box");
		ap.addArgument("width","the width of the box");
		ap.addArgument("heigth","the heigth of the box");
		assertEquals("", ap.getArgumentValue("length"));
		assertEquals("", ap.getArgumentValue("width"));
		assertEquals("", ap.getArgumentValue("heigth"));		
	}
	@Test
	public void checkArgumentValues()
	{
	ap.addArgument("length","the length of the box");
		ap.addArgument("width","the width of the box");
		ap.addArgument("heigth","the heigth of the box");
		ap.setValue("length","7");
		ap.setValue("width","5");
		ap.setValue("heigth","2");
		assertEquals("7", ap.getArgumentValue("length"));
		assertEquals("5", ap.getArgumentValue("width"));
		assertEquals("2", ap.getArgumentValue("heigth"));
		
	}
	
	@Test
	public void checkIfDashHPrintsTheDescriptions()
	{
		ap.addArgument("length","the length of the box");
		ap.addArgument("width","the width of the box");
		ap.addArgument("heigth","the heigth of the box");
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		assertEquals("usage: java VolumeCalculator length width heigth \nCalculate the volume of a box\npositional arguments:\nlength the length of the box\n width the width of the box\n heigth the heigth of the box\n ",
					 ap.getHelpText());
		
		
	}
	
	@Test
	public void parseStringargsToFloatargs(){
		ap.addArgument("length","the length of the box");
		ap.addArgument("width","the width of the box");
		ap.addArgument("heigth","the heigth of the box");
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.setValue("length","7");
		ap.setValue("width","5");
		ap.setValue("heigth","2");
		assertEquals(7,ap.getFloatValue("length"),.1);
		assertEquals(5,ap.getFloatValue("width"),.1);
		assertEquals(2,ap.getFloatValue("heigth"),.1);
	}

	
}
