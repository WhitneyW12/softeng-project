package edu.jsu.mcis;
import java.util.*;

/**
 *@author BabaTunde Idumu
 *@author Michael Quattrochi
 *@author Wesley Schultz
 *@author James Thomas
 *@author Whitney Wood

 *<p>
*This creates TooManyArgumentsException class to handle a case where 
*the arguments given are more than required. This argument extends from 
*RuntimeException, which is the superclass of those exceptions that can be thrown during the 
*normal operation of the Java Virtual Machine.
 */

public class TooManyArgumentsException extends RuntimeException{
	
	/**
	*<p>
	*Constructs a new exception with the specified detail message;
	* in this case it returns the error message.
	*/
	public TooManyArgumentsException(String errorMessage){
		super(errorMessage);
	}
}
