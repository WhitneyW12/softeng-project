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
	public void checkArgumentCreation()
	{
		ap.addArgument("length","the length of the box",Argument.Type.STRING);
		ap.addArgument("width","the width of the box",Argument.Type.STRING);
		ap.addArgument("height","the height of the box",Argument.Type.STRING);
		assertEquals("", ap.getValue("length"));
		assertEquals("", ap.getValue("width"));
		assertEquals("", ap.getValue("height"));		
	}
	@Test
	public void checkArgumentValues()
	{	
		String[] args = new String[] {"7","5","2"};
		ap.addArgument("length","the length of the box",Argument.Type.STRING);
		ap.addArgument("width","the width of the box",Argument.Type.STRING);
		ap.addArgument("height","the height of the box",Argument.Type.STRING);
		ap.parseValues(args);
		assertEquals("7", ap.getValue("length"));
		assertEquals("5", ap.getValue("width"));
		assertEquals("2", ap.getValue("height"));
		
	}
	
	@Test   
	public void checkArgumentDescription(){   
 		ap.addArgument("length","the length of the box",Argument.Type.STRING);
		ap.addArgument("width","the width of the box",Argument.Type.STRING);
		ap.addArgument("height","the height of the box",Argument.Type.STRING); 
 		assertEquals("the length of the box", ap.getDescription("length"));  
 		assertEquals("the width of the box", ap.getDescription("width"));  
 		assertEquals("the height of the box", ap.getDescription("height"));  
 	  
	}  

	
	@Test
	public void checkIfDashHPrintsTheDescriptions()
	{    String[] args = new String[] {"-h","5","2"};
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addArgument("length","the length of the box",Argument.Type.STRING);
		ap.addArgument("width","the width of the box",Argument.Type.STRING);
		ap.addArgument("height","the height of the box",Argument.Type.STRING);
		
		assertEquals("usage: java VolumeCalculator length width height \nCalculate the volume of a box\npositional arguments:\nlength the length of the box\nwidth the width of the box\nheight the height of the box\n",
					 ap.getHelpMessage());
		
		
		
	}
	
	@Test
	public void parseStringargsToDouble(){
		String[] args = new String[] {"7","5","2"};
		ap.addArgument("length","the length of the box",Argument.Type.DOUBLE);
		ap.addArgument("width","the width of the box",Argument.Type.DOUBLE);
		ap.addArgument("height","the height of the box",Argument.Type.DOUBLE);
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.parseValues(args);
		double length = ap.getValue("length");
		double width = ap.getValue("width");
		double height = ap.getValue("height");
		assertEquals(7,length,.1);
		assertEquals(5,width,.1);
		assertEquals(2,height,.1);
	}
	@Test
	public void parseStringToInt(){
		String[] args = new String[] {"7"};
		ap.addArgument("length","the length of the box",Argument.Type.INTEGER);
		ap.parseValues(args);
		assertEquals(7,ap.getValue("length"));
	}
	@Test 
	public void parseStringToBool(){
		String[] args = new String[] {"true"};
		ap.addArgument("length","the length of the box",Argument.Type.BOOLEAN);
		ap.parseValues(args);
		boolean b = ap.getValue("length");
		assertTrue(b);
	}
	@Test
	public void forceTooManyArguments(){
		String[] args = new String[] {"7","5","2","43"};
		ap.addArgument("length","the length of the box",Argument.Type.DOUBLE);
		ap.addArgument("width","the width of the box",Argument.Type.DOUBLE);
		ap.addArgument("height","the height of the box",Argument.Type.DOUBLE);
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		try{
		ap.parseValues(args);
		}
		catch(TooManyArgumentsException e){
		assertEquals("usage: java VolumeCalculator length width height \nVolumeCalculator.java: error: unrecognized arguments: 43",ap.getErrorMessage());
		}
	}
	@Test
	public void forceTooFewArguments(){
		String[] args = new String[] {"7","5"};
		ap.addArgument("length","the length of the box",Argument.Type.DOUBLE);
		ap.addArgument("width","the width of the box",Argument.Type.DOUBLE);
		ap.addArgument("height","the height of the box",Argument.Type.DOUBLE);
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		try{
		ap.parseValues(args);
		}
		catch(TooFewArgumentsException e){
		assertEquals("usage: java VolumeCalculator length width height \nVolumeCalculator.java: error: the following arguments are required: height ",ap.getErrorMessage());
		}
	}
	
	@Test
	public void forceNumberFormatException(){
		String[] args = new String[] {"7","something","2"};
		ap.addArgument("length","the length of the box",Argument.Type.DOUBLE);
		ap.addArgument("width","the width of the box",Argument.Type.DOUBLE);
		ap.addArgument("height","the height of the box",Argument.Type.DOUBLE);
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.parseValues(args);
		assertTrue(ap.getError());
		assertEquals("usage: java VolumeCalculator length width height \nVolumeCalculator.java: error: argument width: invalid double value: something",ap.getErrorMessage());
	}
	@Test
	public void makeNamedArgument(){
		ap.addNamedArgument("length","the length of the box",Argument.Type.STRING,1);
		assertEquals("", ap.getValue("length"));
		
		
	}
	//@Test
	//public void checkShorthand()
	//{
	//	ap.addNamedArgument("--type","the length of the box",Argument.Type.STRING,1);
		//ap.setShorthand("--type","-t");
		//assertEquals("-t", ap.getShorthand("--type"));
		
	//}
	
}
