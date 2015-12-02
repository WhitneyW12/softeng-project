package edu.jsu.mcis;
import java.util.*;

/**
 *@author BabaTunde Idumu
 *@author Michael Quattrochi
 *@author Wesley Schultz
 *@author James Thomas
 *@author Whitney Wood

 *<p>
*This creates WrongFormatException class to handle a case where 
*the format of the paramenters passed in is wrong compared to the required
* format. This also extends from RuntimeException, which
* is the superclass of those exceptions that can be thrown during the 
*normal operation of the Java Virtual Machine.
 */

public class WrongFormatException extends RuntimeException{

	/**
	*<p>
	*Constructs a new exception with the specified detail message;
	* in this case it returns the error message.
	*/
	public WrongFormatException(String errorMessage){
		super(errorMessage);
	}
}