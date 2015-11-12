package edu.jsu.mcis;

public class positionalArgument extends Argument{
	public positionalArgument(Type type, String description){
		super(type, description);
		
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
}