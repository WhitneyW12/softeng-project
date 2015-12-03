package edu.jsu.mcis;
import java.util.*;

/**
*
*This creates InvalidNameException class to handle Invalid Name Exception 
*and extends from RunTime Exception.<br> It occurs when a name that does not corrispond to any argument is entered from the user program.
 *
 *@author BabaTunde Idumu
 *@author Michael Quattrochi
 *@author Wesley Schultz
 *@author James Thomas
 *@author Whitney Wood
*/

public class InvalidNameException extends RuntimeException{

	public InvalidNameException(String errorMessage){
		/**
		*
		*The super constructor returns the errorMessage.
		*/
		super(errorMessage);
	}
}