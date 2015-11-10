package edu.jsu.mcis;

public abstract class Argument
{   
	public enum Type {DOUBLE, INTEGER, STRING, BOOLEAN};
	protected Object argumentValue;
	protected Type argumentType;
	protected String argumentDescription;
	
	public Argument(Type type, String description){
		 argumentType = type;
		 argumentValue = "";
		 argumentDescription = description;
	 }
	 
	
	 public  void setValue(String value){
		if(argumentType == Argument.Type.STRING){
			argumentValue = value;
		}
		else if(argumentType == Argument.Type.DOUBLE){
			
				argumentValue = Double.parseDouble(value);
			
		}
		else if(argumentType == Argument.Type.INTEGER){
			
				argumentValue = Integer.parseInt(value);
			
		}
		else{
			if (value.equals("true")||value.equals("false")){
				argumentValue = Boolean.parseBoolean(value);
			}
			else{
				throw new WrongFormatException("");
			}
		}
		 
	 }
	 public abstract Object getValue();
	 public abstract Type getType();
	 public abstract String getDescription();
	 
	
}