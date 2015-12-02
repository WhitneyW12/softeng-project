package edu.jsu.mcis;
import java.util.*;

/**
 *@author BabaTunde Idumu
 *@author Michael Quattrochi
 *@author Wesley Schultz
 *@author James Thomas
 *@author Whitney Wood

*<p>
*This creates InvalidNameException class to handle Invalid Name Exception.
* The InvalidNameException extends from RunTime Exception. RuntimeException
* is the superclass of those exceptions that can be thrown during the 
*normal operation of the Java Virtual Machine.
*/
public class InvalidNameException extends RuntimeException{

	/**
	*<p>
	*Constructs a new exception with the specified detail message;
	* in this case it returns the error message.
	*/
	public InvalidNameException(String errorMessage){
		super(errorMessage);
	}
}