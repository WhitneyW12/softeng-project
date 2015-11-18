package edu.jsu.mcis;
import java.util.*;

/**
*<p>
*This creates HelpMessageException class to handle Help Message Exception 
*and extends from RunTime Exception.
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