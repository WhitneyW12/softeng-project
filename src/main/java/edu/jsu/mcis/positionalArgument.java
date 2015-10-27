package edu.jsu.mcis;

public class positionalArgument extends Argument{
	private Object argumentValue;
	public positionalArgument(Type type, String description, Object argumentValue){
		super(type, description);
		this.argumentValue = argumentValue;
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
	
}	
