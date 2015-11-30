package edu.jsu.mcis;
import java.util.*;

/**
*<p>
*This creates NoSuchArgumentException class to handle a case where 
*there is No Such Argument present, and it extends from RunTime Exception.
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
		*<p>
		*The super constructor returns the errorMessage.
		*/
		super(errorMessage);
	}
}