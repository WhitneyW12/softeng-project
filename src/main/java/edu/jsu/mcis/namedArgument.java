package edu.jsu.mcis;
public class namedArgument extends Argument{
	private int numberOfValues;
	private Object[] argumentValues;
	private boolean hasRestricted; 
	private Object argumentValue;

	public namedArgument(Type type, String description, int numberOfValues, String[] restrictedValues){
		  super(type,description,restrictedValues);
		 this.numberOfValues = numberOfValues;
		 hasRestricted = false;
		 
	 }
	 
	
	 
	
}
	
	
	
