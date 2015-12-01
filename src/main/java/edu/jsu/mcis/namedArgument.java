package edu.jsu.mcis;

/**
 *This program creates a namedArgument class that extends Argument class.
 *It has methods that allow the user to get the description, the value and the data type of the argument.
 *Named arguments are not required arguments that have to be called in the comand prompt to change the value
 *
 *@author BabaTunde Idumu
 *@author Michael Quattrochi
 *@author Wesley Schultz
 *@author James Thomas
 *@author Whitney Wood
 */
 
public class namedArgument extends Argument{

	/**
	 *This method returns the type and description of the argument.
	 *
	 *@param type The type of the argument.
	 *@param description The description of the argument.
	 */
	public namedArgument(Type type, String description){
		 super(type,description);
	 }

	 /**
	 *The getDescription method returns the argument description.
	 *
	 *@param description The description of the argument.
	 *@return The argumentDescription.
	 */
	 public String getDescription(){
		 return argumentDescription;
	 }

	 /**
	 *The getValue method returns the returns the argument value.
	 *
	 *@param value The value of the argument.
	 *@return The argumentValue.
	 */
	 public Object getValue(){
		 return argumentValue;
	 }

	 /**
	 *The getType method returns the returns the argument type.
	 *
	 *@param type The type of the argument.
	 *@return The argumentType.
	 */
	 public Type getType(){
		 return argumentType;
	 }
}
	
	
