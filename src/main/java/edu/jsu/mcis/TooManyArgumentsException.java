/**
*<p>
*This creates TooManyArgumentsException class to handle a case where there 
*are Too Many Arguments present, and it extends from RunTime Exception.
 *
 *@author BabaTunde Idumu
 *@author Michael Quattrochi
 *@author Wesley Schultz
 *@author James Thomas
 *@author Whitney Wood
*/
package edu.jsu.mcis;
import java.util.*;

public class TooManyArgumentsException extends RuntimeException{
	
	public TooManyArgumentsException(String errorMessage){
		/**
		*<p>
		*The super constructor returns the errorMessage.
		*/
		super(errorMessage);
	}
}
