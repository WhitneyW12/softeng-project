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
		ap.addPositionalArgument("length","the length of the box",Argument.Type.STRING);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.STRING);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.STRING);
		assertEquals("", ap.getValue("length"));
		assertEquals("", ap.getValue("width"));
		assertEquals("", ap.getValue("height"));		
	}
	
	@Test
	public void checkArgumentValues()
	{	
		String[] args = new String[] {"7","5","2"};
		ap.addPositionalArgument("length","the length of the box",Argument.Type.STRING);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.STRING);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.STRING);
		ap.parseValues(args);
		assertEquals("7", ap.getValue("length"));
		assertEquals("5", ap.getValue("width"));
		assertEquals("2", ap.getValue("height"));
		
	}
	
	@Test   
	public void checkArgumentDescription(){   
 		ap.addPositionalArgument("length","the length of the box",Argument.Type.STRING);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.STRING);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.STRING); 
 		assertEquals("the length of the box", ap.getDescription("length"));  
 		assertEquals("the width of the box", ap.getDescription("width"));  
 		assertEquals("the height of the box", ap.getDescription("height"));  
 	  
	}  

	@Test
	public void checkIfDashHThrowsException(){
		String[] args = new String[] {"-h","5","2"};
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addPositionalArgument("length","the length of the box",Argument.Type.STRING);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.STRING);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.STRING);
		try{
			ap.parseValues(args);
			assertTrue(false);
		}
		catch(RuntimeException ex){
			assertEquals("usage: java VolumeCalculator length width height \nCalculate the volume of a box\npositional arguments:\nlength the length of the box\nwidth the width of the box\nheight the height of the box\n",
			ap.getHelpMessage());
		}
	}
	
	@Test
	public void checkIfDashDashHelpThrowsException(){
		String[] args = new String[] {"--help","5","2"};
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addPositionalArgument("length","the length of the box",Argument.Type.STRING);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.STRING);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.STRING);
		try{
			ap.parseValues(args);
		}
		catch(RuntimeException ex){
			assertEquals("usage: java VolumeCalculator length width height \nCalculate the volume of a box\npositional arguments:\nlength the length of the box\nwidth the width of the box\nheight the height of the box\n",
			ap.getHelpMessage());
		}
	}
	
	@Test
	public void checkHelpMessage(){
		String[] args = new String[] {"h","5","2"};
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addPositionalArgument("length","the length of the box",Argument.Type.STRING);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.STRING);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.STRING);
		assertEquals("usage: java VolumeCalculator length width height \nCalculate the volume of a box\npositional arguments:\nlength the length of the box\nwidth the width of the box\nheight the height of the box\n",
		ap.getHelpMessage());
	}
		
	@Test
	public void parseStringargsToDouble(){
		String[] args = new String[] {"7","5","2"};
		ap.addPositionalArgument("length","the length of the box",Argument.Type.DOUBLE);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.DOUBLE);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.DOUBLE);
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
		ap.addPositionalArgument("length","the length of the box",Argument.Type.INTEGER);
		ap.parseValues(args);
		assertEquals(7,ap.getValue("length"));
	}
	
	@Test 
	public void parseStringToBool(){
		String[] args = new String[] {"true"};
		ap.addPositionalArgument("length","the length of the box",Argument.Type.BOOLEAN);
		ap.parseValues(args);
		boolean b = ap.getValue("length");
		assertTrue(b);
	}
	
	@Test
	public void forceTooManyArguments(){
		String[] args = new String[] {"7","5","2","43"};
		ap.addPositionalArgument("length","the length of the box",Argument.Type.DOUBLE);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.DOUBLE);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.DOUBLE);
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		try{
			ap.parseValues(args);
		}
		catch(RuntimeException e){
			assertEquals("usage: java VolumeCalculator length width height \nVolumeCalculator.java: error: unrecognized arguments: 43",ap.getErrorMessage());
		}
	}
	
	@Test
	public void forceTooFewArguments(){
		String[] args = new String[] {"7","5"};
		ap.addPositionalArgument("length","the length of the box",Argument.Type.DOUBLE);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.DOUBLE);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.DOUBLE);
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		try{
			ap.parseValues(args);
		}
		catch(RuntimeException e){
			assertEquals("usage: java VolumeCalculator length width height \nVolumeCalculator.java: error: the following arguments are required: height ",ap.getErrorMessage());
		}
	}
	
	@Test
	public void forceNumberFormatException(){
		String[] args = new String[] {"7","something","2"};
		ap.addPositionalArgument("length","the length of the box",Argument.Type.DOUBLE);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.DOUBLE);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.DOUBLE);
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		try{
			ap.parseValues(args);
		}
		catch(RuntimeException e){
			assertTrue(ap.getError());
			assertEquals("usage: java VolumeCalculator length width height \nVolumeCalculator.java: error: argument width: invalid double value: something",ap.getErrorMessage());
		}
	}
	
	@Test
	public void makeNamedArgument(){
		ap.addNamedArgument("length","the length of the box",Argument.Type.STRING,"","l");
		assertEquals("", ap.getValue("length"));
	}
	
	
	
	@Test
	public void checkNamedArgumentValue(){
		String[] args = new String[] {"--type", "elipsoid"};
		ap.addNamedArgument("type","",Argument.Type.STRING,"box","t");
		ap.addNamedArgument("digits","prints help message",Argument.Type.INTEGER,"4","d");
		ap.parseValues(args);
		assertEquals("elipsoid", ap.getValue("type"));
	}
	
	@Test
	public void checkNamedArgumentDefaultValue(){
		
		ap.addNamedArgument("type","",Argument.Type.STRING,"box","t");
		assertEquals("box", ap.getValue("type"));
	}
	
	@Test
	public void checkArgumentTypeDouble(){
		ap.addPositionalArgument("length","the length of the box",Argument.Type.DOUBLE);
		assertEquals(Argument.Type.DOUBLE, ap.getArgumentType("length"));
	}
	public void checkArgumentTypeString(){
		ap.addPositionalArgument("length","the length of the box",Argument.Type.STRING);
		assertEquals(Argument.Type.STRING, ap.getArgumentType("length"));
	}
	public void checkArgumentTypeINT(){
		ap.addPositionalArgument("length","the length of the box",Argument.Type.INTEGER);
		assertEquals(Argument.Type.INTEGER, ap.getArgumentType("length"));
	}
	public void checkArgumentTypeBoolean(){
		ap.addPositionalArgument("length","the length of the box",Argument.Type.BOOLEAN);
		assertEquals(Argument.Type.BOOLEAN, ap.getArgumentType("length"));
	}
	
	
	@Test
	public void TestMultipleNamedArguments()
	{
		String[] args = new String[] {"7","5","2","--type","ellipsoid","--digits","1"};
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addPositionalArgument("length","the length of the box",Argument.Type.STRING);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.STRING);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.STRING);
		ap.addNamedArgument("type","prints help message",Argument.Type.STRING,"box","t");
		ap.addNamedArgument("digits","prints help message",Argument.Type.INTEGER,"4","d");
		ap.parseValues(args);
		String length= ap.getValue("length");
		String width= ap.getValue("width");
		String height= ap.getValue("height");
		String type = ap.getValue("type");
		int digits = ap.getValue("digits");
		
		assertEquals("7",length);
		assertEquals("5",width);
		assertEquals("2",height);
		assertEquals("ellipsoid",type);
		assertEquals(1,digits);
		
	}
		@Test
	public void TestMultipleNamedArgumentsAnywhere()
	{
		String[] args = new String[] {"--type","ellipsoid","7","5","2","--digits","1"};
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addPositionalArgument("length","the length of the box",Argument.Type.STRING);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.STRING);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.STRING);
		ap.addNamedArgument("type","prints help message",Argument.Type.STRING,"box","t");
		ap.addNamedArgument("digits","prints help message",Argument.Type.INTEGER,"4","d");
		ap.parseValues(args);
		String length= ap.getValue("length");
		String width= ap.getValue("width");
		String height= ap.getValue("height");
		String type = ap.getValue("type");
		int digits = ap.getValue("digits");
		
		assertEquals("7",length);
		assertEquals("5",width);
		assertEquals("2",height);
		assertEquals("ellipsoid",type);
		assertEquals(1,digits);
		
	}
	@Test
	public void checkFlag()
	{
		String[] args = new String[] {"7","--test","5","2"};
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addPositionalArgument("length","the length of the box",Argument.Type.STRING);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.STRING);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.STRING);
		ap.addNamedArgument("type","prints help message",Argument.Type.STRING,"box","t");
		ap.addNamedArgument("digits","prints help message",Argument.Type.INTEGER,"4","d");
		ap.addNamedArgument("test","prints help message",Argument.Type.BOOLEAN,"false","e");
		try{
		ap.parseValues(args);
		}
		catch(RuntimeException ex){
		boolean b = ap.getValue("test");
		assertTrue(b);
		}
		
		
		
	}
	@Test
	public void TestBooleanNamedArg(){
		String[] args = new String[] {"7","--test","5","2"};
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addPositionalArgument("length","the length of the box",Argument.Type.STRING);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.STRING);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.STRING);
		ap.addNamedArgument("type","prints help message",Argument.Type.STRING,"box","t");
		ap.addNamedArgument("digits","prints help message",Argument.Type.INTEGER,"4","d");
		ap.addNamedArgument("test","prints help message",Argument.Type.BOOLEAN,"false","e");
		ap.parseValues(args);
		boolean b = ap.getValue("test");
		assertTrue(b);
	}
	@Test
	public void TestDoubleNamedArg(){
		String[] args = new String[] {"7","--test","5","5","2"};
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addPositionalArgument("length","the length of the box",Argument.Type.STRING);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.STRING);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.STRING);
		ap.addNamedArgument("type","prints help message",Argument.Type.STRING,"box","t");
		ap.addNamedArgument("digits","prints help message",Argument.Type.INTEGER,"4","d");
		ap.addNamedArgument("test","prints help message",Argument.Type.DOUBLE,"5","e");
		ap.parseValues(args);
		double b = ap.getValue("test");
		assertEquals(5,b,.001);
	}
	@Test
	public void TestDoubleNamedArgError(){
		String[] args = new String[] {"7","--test","something","5","2"};
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addPositionalArgument("length","the length of the box",Argument.Type.STRING);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.STRING);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.STRING);
		ap.addNamedArgument("type","prints help message",Argument.Type.STRING,"box","t");
		ap.addNamedArgument("digits","prints help message",Argument.Type.INTEGER,"4","d");
		ap.addNamedArgument("test","prints help message",Argument.Type.DOUBLE,"5","e");
		try{
		ap.parseValues(args);
		assertTrue(false);
		}
		catch(RuntimeException ex ){
			assertTrue(true);
		}
		
	}
	
	@Test
	public void testFalseArgument(){
		String[] args = new String[] {"7","--myarg","something","5","2"};
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addPositionalArgument("length","the length of the box",Argument.Type.STRING);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.STRING);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.STRING);
		ap.addNamedArgument("type","prints help message",Argument.Type.STRING,"box","t");
		ap.addNamedArgument("digits","prints help message",Argument.Type.INTEGER,"4","d");
		ap.addNamedArgument("test","prints help message",Argument.Type.BOOLEAN,"false","e");
		try{
		ap.parseValues(args);
		assertTrue(false);
		}
		catch(RuntimeException ex){
			assertTrue(true);
		}
		
		
	}
	@Test
	public void TestIntNamedArgException(){
		String[] args = new String[] {"7","--test","something","5","2"};
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addPositionalArgument("length","the length of the box",Argument.Type.STRING);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.STRING);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.STRING);
		ap.addNamedArgument("type","prints help message",Argument.Type.STRING,"box","t");
		ap.addNamedArgument("digits","prints help message",Argument.Type.INTEGER,"4","d");
		ap.addNamedArgument("test","prints help message",Argument.Type.INTEGER,"5","e");
		try{
		ap.parseValues(args);
		assertTrue(false);
		}
		catch(RuntimeException ex){
			assertTrue(true);
		}
		
	}
	@Test
	public void TestBooleanNamedArgException(){
		String[] args = new String[] {"7","--test","something","5","2"};
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addPositionalArgument("length","the length of the box",Argument.Type.STRING);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.STRING);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.STRING);
		ap.addNamedArgument("type","prints help message",Argument.Type.STRING,"box","t");
		ap.addNamedArgument("digits","prints help message",Argument.Type.INTEGER,"4","d");
		ap.addNamedArgument("test","prints help message",Argument.Type.BOOLEAN,"false","e");
		try{
		ap.parseValues(args);
		assertTrue(false);
		}
		catch(RuntimeException ex){
			assertTrue(true);
		}
		
	}
	@Test
	public void TestBooleanPositionalArgException(){
		
		String[] args = new String[] {"7","5","2"};
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addPositionalArgument("length","the length of the box",Argument.Type.STRING);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.STRING);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.BOOLEAN);
		ap.addNamedArgument("type","prints help message",Argument.Type.STRING,"box","t");
		ap.addNamedArgument("digits","prints help message",Argument.Type.INTEGER,"4","d");
		ap.addNamedArgument("test","prints help message",Argument.Type.BOOLEAN,"false","e");
		try{
		ap.parseValues(args);
		assertTrue(false);
		}
		catch(RuntimeException ex){
			assertTrue(true);
		}
	}
	@Test
	public void TestIntPositionalArgException(){
		
		String[] args = new String[] {"7","5","bob"};
		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
		ap.addPositionalArgument("length","the length of the box",Argument.Type.STRING);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.STRING);
		ap.addPositionalArgument("height","the height of the box",Argument.Type.INTEGER);
		ap.addNamedArgument("type","prints help message",Argument.Type.STRING,"box","t");
		ap.addNamedArgument("digits","prints help message",Argument.Type.INTEGER,"4","d");
		ap.addNamedArgument("test","prints help message",Argument.Type.BOOLEAN,"false","e");
		try{
		ap.parseValues(args);
		assertTrue(false);
		}
		catch(RuntimeException ex){
			assertTrue(true);
		}
	}
	@Test 
	public void testOrderofArguments(){
		String[] args = new String[] {"s","5","bob"};
		ap.addProgram("Calculator","Calculate addition, subtraction or multiplication");
		ap.addPositionalArgument("length","the length of the box",Argument.Type.INTEGER);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.INTEGER);
		ap.addNamedArgument("add","prints help message",Argument.Type.BOOLEAN,"false","a");
		ap.addNamedArgument("subtract","prints help message",Argument.Type.BOOLEAN,"false","s");
		try{
		ap.parseValues(args);
		}
		catch(RuntimeException ex){
			assertTrue(true);
		}
	}
	

@Test
public void testSavingtoXMLFile(){
	ap.addProgram("Calculator","Calculate addition, subtraction or multiplication");
		ap.addPositionalArgument("length","the length of the box",Argument.Type.INTEGER);
		ap.addPositionalArgument("width","the width of the box",Argument.Type.INTEGER);
		ap.addNamedArgument("add","prints help message",Argument.Type.BOOLEAN,"false","a");
		ap.addNamedArgument("subtract","prints help message",Argument.Type.BOOLEAN,"false","s");
		ap.saveXML("newXML.xml");
	
}
}