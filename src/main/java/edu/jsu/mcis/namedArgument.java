package edu.jsu.mcis;

/**
 *This program creates a namedArgument class that extends Argument class.
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
	 */
	public namedArgument(Type type, String description){
		 super(type,description);
	 }

	 /**
	 *The getDescription method returns the argument description.
	 */
	 public String getDescription(){
		 return argumentDescription;
	 }

	 /**
	 *The getValue method returns the returns the argument value.
	 */
	 public Object getValue(){
		 return argumentValue;
	 }

	 /**
	 *The getType method returns the returns the argument type.
	 */
	 public Type getType(){
		 return argumentType;
	 }
}
	
	
