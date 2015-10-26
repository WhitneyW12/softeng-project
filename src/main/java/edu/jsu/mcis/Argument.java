package edu.jsu.mcis;
public class Argument
{   
	public enum Type {DOUBLE, INTEGER, STRING, BOOLEAN};
	private Type argumentType;
	private Object argumentValue;
	private String argumentDescription;
	private String[] restrictedValues;
	private boolean hasRestricted; 
	private int numberOfValues;
	public Argument(Type type, String description, String[] restrictedValues,int numberOfValues){
		  argumentType = type;
		 argumentValue = "";
		 argumentDescription = description;
		 hasRestricted = false;
		 this.restrictedValues = restrictedValues;
		 this.numberOfValues=numberOfValues;
		 
	 }
	public Argument(Type type, String description){
		this(type,description,null,1);
		
		 
	 }
	 
	 
	 
	 public void setValue(Object value){
		 argumentValue = value;
	 }
	 public String getDescription(){
		 return argumentDescription;
	 }
	 public Object getValue(){
		 return argumentValue;
	 }
	 public Type getType(){
		 return argumentType;
	 }
	 public boolean getHasRestricted(){
		 
		 return hasRestricted;
	 }
	 public String[] getRestrictedValues(){
		 return restrictedValues;
	 }
	 public void setHasRestricted(boolean b){
		 
		 hasRestricted = b;
	 }
	 public int getNumberOfValues(){
		 return numberOfValues;
	 }
}