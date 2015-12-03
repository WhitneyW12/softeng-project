package edu.jsu.mcis;
import java.util.*;

/**
*
*This creates TooFewArgumentsException class to handle a case where 
*there are Too Few Arguments present, and it extends from RunTime Exception.<br> This occurs when not enough postional arguments are entered in the command prompt
 *
 *@author BabaTunde Idumu
 *@author Michael Quattrochi
 *@author Wesley Schultz
 *@author James Thomas
 *@author Whitney Wood
*/

public class TooFewArgumentsException extends RuntimeException{
	
	public TooFewArgumentsException(String errorMessage){
		/**
		*
		*The super constructor returns the errorMessage.
		*/
		super(errorMessage);
	}
}
