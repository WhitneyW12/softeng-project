package edu.jsu.mcis;

abstract class Argument
{   
	protected enum Type {DOUBLE, INTEGER, STRING, BOOLEAN};
	protected Object argumentValue;
	protected Type argumentType;
	protected String argumentDescription;
	protected String[] restrictedValues;
	protected boolean hasRestricted; 
	
	public Argument(Type type, String description, String[] restrictedValues){
		 argumentType = type;
		 argumentValue = "";
		 argumentDescription = description;
		 hasRestricted = false;
		 this.restrictedValues = restrictedValues; 
	 }
	 
	public Argument(Type type, String description){
		this(type,description, null); 
	 }
	
	 public abstract void setValue(Object value);
	 public abstract Object getValue();
	 public abstract Type getType();
	 
	
}