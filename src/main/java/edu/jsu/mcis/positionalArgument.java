package edu.jsu.mcis;
/**
 *This program creates a positionalArgumentclass that extends Argument class.
 *
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