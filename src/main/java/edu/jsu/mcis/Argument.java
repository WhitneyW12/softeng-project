package edu.jsu.mcis;
public class Argument
{   
	public enum Type {DOUBLE, INTEGER, STRING, BOOLEAN};
	private Type argumentType;
	private String argumentName;
	private Object argumentValue;
	private String argumentDescription;
	public Argument(Type type, String name, String description){
		  argumentType = type;
		 argumentName = name;
		 argumentValue = "";
		 argumentDescription = description;
		 
	 }
	 
	 public void setValue(Object value){
		 argumentValue = value;
	 }
	 public String getName(){
		 return argumentName;
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
}