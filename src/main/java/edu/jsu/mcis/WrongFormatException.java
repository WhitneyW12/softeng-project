package edu.jsu.mcis;
import java.util.*;

/**
*<p>
*This creates WrongFormatException class to handle a case where 
*the Format is Wrong, and it extends from RunTime Exception.
 *
 *@author BabaTunde Idumu
 *@author Michael Quattrochi
 *@author Wesley Schultz
 *@author James Thomas
 *@author Whitney Wood
*/

public class WrongFormatException extends RuntimeException{

	public WrongFormatException(String errorMessage){
		/**
		*<p>
		*The super constructor returns the errorMessage.
		*/
		super(errorMessage);
	}
}