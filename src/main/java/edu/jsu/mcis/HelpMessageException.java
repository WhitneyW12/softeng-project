package edu.jsu.mcis;
import java.util.*;

/**
*<p>
*This creates HelpMessageException class to handle Help Message Exception 
*and extends from RunTime Exception.<br>It occurs when --help or -h is entered into the command prompt
 *
 *@author BabaTunde Idumu
 *@author Michael Quattrochi
 *@author Wesley Schultz
 *@author James Thomas
 *@author Whitney Wood
*/

public class HelpMessageException extends RuntimeException{

	public HelpMessageException(String errorMessage){
		/**
		*<p>
		*The super constructor returns the errorMessage.
		*/
		super(errorMessage);
	}
}