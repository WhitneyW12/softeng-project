package edu.jsu.mcis;
import java.util.*;

/**
 *@author BabaTunde Idumu
 *@author Michael Quattrochi
 *@author Wesley Schultz
 *@author James Thomas
 *@author Whitney Wood

*<p>
*This creates HelpMessageException class to handle Help Message Exception. 
*The HelpMessageException extends from RunTime Exception. RuntimeException
* is the superclass of those exceptions that can be thrown during the 
*normal operation of the Java Virtual Machine.
*/
public class HelpMessageException extends RuntimeException{

	/**
	*<p>
	*Constructs a new exception with the specified detail message;
	* in this case it returns the error message.
	*/
	public HelpMessageException(String errorMessage){
		super(errorMessage);
	}
}