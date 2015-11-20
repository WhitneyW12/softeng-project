/**
*<p>
*This program creates a namedArgument class that extends Argument class.
 *
 *@author BabaTunde Idumu
 *@author Michael Quattrochi
 *@author Wesley Schultz
 *@author James Thomas
 *@author Whitney Wood
*/
package edu.jsu.mcis;
public class namedArgument extends Argument{
	

	public namedArgument(Type type, String description){
		/**
		*<p>
		*The super constructor returns the type and description.
		*/
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
	
	
