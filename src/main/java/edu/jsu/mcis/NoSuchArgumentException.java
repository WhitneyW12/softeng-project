package edu.jsu.mcis;
import java.util.*;

/**
<<<<<<< HEAD
*<p>
*This creates NoSuchArgumentException class to handle a case where 
*there is No Such Argument present, and it extends from RunTime Exception.<br> this occurs when a named argument is called in the command prompt but it does not exist in the program.
 *
=======
>>>>>>> 3f53a2b9b421c7d01d8057752c88e9c718631f17
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