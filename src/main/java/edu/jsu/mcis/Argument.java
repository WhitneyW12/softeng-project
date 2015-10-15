package edu.jsu.mcis;
public class Argument
{   
	public enum Type {DOUBLE, INTEGER, STRING, BOOLEAN};
	private Type argumentType;
	private Object argumentValue;
	private String argumentDescription;
	private String[] restrictedValues;
	private boolean hasRestricted; 
	public Argument(Type type, String description, String[] restrictedValues){
		  argumentType = type;
		 argumentValue = "";
		 argumentDescription = description;
		 hasRestricted = false;
		 this.restrictedValues = restrictedValues;
		 
	 }
	public Argument(Type type, String description){
		this(type,description,null);
		 
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
}