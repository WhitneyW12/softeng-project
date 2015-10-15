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
	public void checkIfDashHThrowsException()
	{    String[] args = new String[] {"-h","5","2"};
		
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addArgument("length","the length of the box",Argument.Type.STRING);
		ap.addArgument("width","the width of the box",Argument.Type.STRING);
		ap.addArgument("height","the height of the box",Argument.Type.STRING);
		ap.addNamedArgument("--help","prints help message",Argument.Type.BOOLEAN,0,false);
		try{
		ap.parseValues(args);
		}
		catch(HelpMessageException ex){
		assertEquals("usage: java VolumeCalculator length width height \nCalculate the volume of a box\npositional arguments:\nlength the length of the box\nwidth the width of the box\nheight the height of the box\n",
					 ap.getHelpMessage());
		
		}
		
	}
	@Test
	public void checkIfDashDashHelpThrowsException()
	{    String[] args = new String[] {"--help","5","2"};
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addArgument("length","the length of the box",Argument.Type.STRING);
		ap.addArgument("width","the width of the box",Argument.Type.STRING);
		ap.addArgument("height","the height of the box",Argument.Type.STRING);
		ap.addNamedArgument("--help","prints help message",Argument.Type.BOOLEAN,0,false);
		try{
		ap.parseValues(args);
		}
		catch(HelpMessageException ex){
		assertEquals("usage: java VolumeCalculator length width height \nCalculate the volume of a box\npositional arguments:\nlength the length of the box\nwidth the width of the box\nheight the height of the box\n",
					 ap.getHelpMessage());
		
		}
		
	}
	@Test
	public void checkHelpMessage()
	{    String[] args = new String[] {"-h","5","2"};
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addArgument("length","the length of the box",Argument.Type.STRING);
		ap.addArgument("width","the width of the box",Argument.Type.STRING);
		ap.addArgument("height","the height of the box",Argument.Type.STRING);
		ap.addNamedArgument("--help","prints help message",Argument.Type.BOOLEAN,0,false);
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
		try{
		ap.parseValues(args);
		}
		catch(NumberFormatException e){
		assertTrue(ap.getError());
		assertEquals("usage: java VolumeCalculator length width height \nVolumeCalculator.java: error: argument width: invalid double value: something",ap.getErrorMessage());
		}
	}
	@Test
	public void makeNamedArgument(){
		ap.addNamedArgument("length","the length of the box",Argument.Type.STRING,1,"");
		assertEquals("", ap.getValue("length"));
		
		
	}
	@Test
	public void checkNamedArgumentValue(){
		String [] restrictedValues = new String[]{"box","elipsoid"};
		String[] args = new String[] {"--type", "elipsoid"};
		ap.addNamedArgument("--type","",Argument.Type.STRING,1,"box",restrictedValues);
		ap.parseValues(args);
		assertEquals("elipsoid", ap.getValue("--type"));
		
		
	}
	@Test
	public void checkNamedArgumentDefaultValue(){
		String [] restrictedValues = new String[]{"box","elipsoid"};
		ap.addNamedArgument("--type","",Argument.Type.STRING,1,"box",restrictedValues);
		assertEquals("box", ap.getValue("--type"));
		
		
	}
	@Test
	public void checkArgumentTypeDouble(){
		ap.addArgument("length","the length of the box",Argument.Type.DOUBLE);
		assertEquals(Argument.Type.DOUBLE, ap.getArgumentType("length"));
		
	}
	public void checkArgumentTypeString(){
		ap.addArgument("length","the length of the box",Argument.Type.STRING);
		assertEquals(Argument.Type.STRING, ap.getArgumentType("length"));
		
	}
	public void checkArgumentTypeINT(){
		ap.addArgument("length","the length of the box",Argument.Type.INTEGER);
		assertEquals(Argument.Type.INTEGER, ap.getArgumentType("length"));
		
	}
	public void checkArgumentTypeBoolean(){
		ap.addArgument("length","the length of the box",Argument.Type.BOOLEAN);
		assertEquals(Argument.Type.BOOLEAN, ap.getArgumentType("length"));
		
	}
	@Test
	public void checkRestrictedValuesException(){
		String [] restrictedValues= new String[]{"box","elipsoid"};
		String[] args = new String[] {"--type", "7"};
		ap.addNamedArgument("--type","",Argument.Type.STRING,1,"box",restrictedValues);
		try{
		ap.parseValues(args);
		assertTrue(false);
		}
		catch(RestrictedValuesException ex){
		assertTrue(true);
		}
		
	}
	
}
