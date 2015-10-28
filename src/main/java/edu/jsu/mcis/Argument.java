package edu.jsu.mcis;

public abstract class Argument
{   
	public enum Type {DOUBLE, INTEGER, STRING, BOOLEAN};
	protected Object argumentValue;
	protected Type argumentType;
	protected String argumentDescription;
	protected int numberOfValues;
	protected String shorthand;
	
	public Argument(Type type, String description){
		 argumentType = type;
		 argumentValue = "";
		 argumentDescription = description;
	 }
	 
	
	 public abstract void setValue(Object value);
	 public abstract Object getValue();
	 public abstract Type getType();
	 public abstract String getDescription();
	 public abstract int getNumberOfValues();
	 public abstract String getShorthand();
	 public abstract void setShorthand(String s);
	 
	
}