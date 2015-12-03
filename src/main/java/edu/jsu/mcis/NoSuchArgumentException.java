package edu.jsu.mcis;
import java.util.*;

/**
*
*This creates NoSuchArgumentException class to handle a case where 
*there is No Such Argument present, and it extends from RunTime Exception.<br> this occurs when a named argument is called in the command prompt but it does not exist in the program.
 *
 *@author BabaTunde Idumu
 *@author Michael Quattrochi
 *@author Wesley Schultz
 *@author James Thomas
 *@author Whitney Wood
*/

public class NoSuchArgumentException extends RuntimeException{

	public NoSuchArgumentException(String errorMessage){
		/**
		*
		*The super constructor returns the errorMessage.
		*/
		super(errorMessage);
	}
}