package edu.jsu.mcis;
/**
 *This program creates a positionalArgument class that extends Argument class.<br>
 *It has methods that allow the user to get the description, the value and the data type of the argument.<br>
 *Positional arguments have a specific order that they have to be entered in the comand prompt to change thier value.
 *@author BabaTunde Idumu
 *@author Michael Quattrochi
 *@author Wesley Schultz
 *@author James Thomas
 *@author Whitney Wood
 */
public class positionalArgument extends Argument{
	public positionalArgument(Type type, String description){
		super(type, description);
		
	}
	 public String getDescription(){
		 /**
		*<p>
		*The getDescription returns the argument description.
		*/
 		 return argumentDescription;
 	 }
 	 public Object getValue(){
		 /**
		*<p>
		*The getValue returns the argument value.
		*/
 		 return argumentValue;
 	 }
 	 public Type getType(){
		 /**
		*<p>
		*The getType returns the argument type.
		*/
 		 return argumentType;
 	 }
}