package edu.jsu.mcis;
import java.util.*;

/**
<<<<<<< HEAD
*<p>
*This creates InvalidNameException class to handle Invalid Name Exception 
*and extends from RunTime Exception.<br> It occurs when a name that does not corrispond to any argument is entered from the user program.
 *
=======
>>>>>>> 3f53a2b9b421c7d01d8057752c88e9c718631f17
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