package edu.jsu.mcis;
public class namedArgument extends Argument{
	private int numberOfValues;
	private Object[] argumentValues;
	public namedArgument(Type type, String description, int numberOfValues){
		  super(type,description);
		 this.numberOfValues = numberOfValues;
		
		 
	 }
	
}
	
	
	
