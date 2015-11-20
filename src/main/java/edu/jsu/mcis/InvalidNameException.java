/**
*<p>
*This creates InvalidNameException class to handle Invalid Name Exception 
*and extends from RunTime Exception.
 *
 *@author BabaTunde Idumu
 *@author Michael Quattrochi
 *@author Wesley Schultz
 *@author James Thomas
 *@author Whitney Wood
*/
package edu.jsu.mcis;
import java.util.*;

public class InvalidNameException extends RuntimeException{

	public InvalidNameException(String errorMessage){
		/**
		*<p>
		*The super constructor returns the errorMessage.
		*/
		super(errorMessage);
	}
}