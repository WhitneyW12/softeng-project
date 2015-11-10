package edu.jsu.mcis;
public class namedArgument extends Argument{
	

	public namedArgument(Type type, String description){
		 super(type,description);
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
	
	
