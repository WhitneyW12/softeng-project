package edu.jsu.mcis;
public class namedArgument extends Argument{
	

	public namedArgument(Type type, String description){
		 super(type,description);
		shorthand="";
	 }

	 public void setShorthand(String s){
		 shorthand = s;
	 }
	 public String getShorthand(){
		 return shorthand;
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
	 
	 
	 
	 
	 
	}
	
	
