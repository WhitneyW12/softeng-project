package edu.jsu.mcis;
import java.util.*;


/**
*<p>
*This creates TooFewArgumentsException class to handle a case where 
*there are Too Few Arguments present, and it extends from RunTime Exception.
*/
public class TooFewArgumentsException extends RuntimeException{
	
	public TooFewArgumentsException(String errorMessage){
		/**
		*<p>
		*The super constructor returns the errorMessage.
		*/
		super(errorMessage);
	}
}
