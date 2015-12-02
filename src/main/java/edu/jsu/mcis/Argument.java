
package edu.jsu.mcis;
/**
 *This is the abstract class that is the parent class for the namedArgument and positionalArgument classes.
 *it also contains the enumerated type that defines the data type of each argument.
 *
 *@author BabaTunde Idumu
 *@author Michael Quattrochi
 *@author Wesley Schultz
 *@author James Thomas
 *@author Whitney Wood
 */
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
	 
	/**
	 *This method takes in a value and sets it as the argument's value. The argument type is used to set the argument to the correct data type.
	 *
	 *@param value The new argument value.
	 *@throws WrongFormatException
	 */
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