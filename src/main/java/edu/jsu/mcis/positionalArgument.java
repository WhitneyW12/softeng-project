package edu.jsu.mcis;

public class positionalArgument extends Argument{
	public positionalArgument(Type type, String description){
		super(type, description);
		shorthand="";
	}
	
	 public void setValue(Object value){
		 argumentValue = value;
	 }

	 public Object getValue(){
		 return argumentValue;
	 }
	 public Type getType(){
		 return argumentType;
	 }
	 public  String getDescription(){
		 return argumentDescription;
	 }
	public void setShorthand(String s){
		 shorthand = s;
	 }
	 public String getShorthand(){
		 return shorthand;
	 }
}	
