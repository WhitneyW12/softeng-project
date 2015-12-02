package edu.jsu.mcis;
import java.util.*;

/**
 *@author BabaTunde Idumu
 *@author Michael Quattrochi
 *@author Wesley Schultz
 *@author James Thomas
 *@author Whitney Wood

*<p>
*This creates NoSuchArgumentException class to handle a case where 
*there is No Such Argument present, and it extends from RunTime Exception. 
* RuntimeException is the superclass of those exceptions that can be thrown during the 
*normal operation of the Java Virtual Machine.
*/
public class NoSuchArgumentException extends RuntimeException{

	/**
	*<p>
	*Constructs a new exception with the specified detail message;
	* in this case it returns the error message.
	*/
	public NoSuchArgumentException(String errorMessage){
		super(errorMessage);
	}
}