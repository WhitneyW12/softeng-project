package edu.jsu.mcis;
import java.util.*;

/**
*<p>
*This creates InvalidNameException class to handle Invalid Name Exception 
*and extends from RunTime Exception.
*/
public class InvalidNameException extends RuntimeException{

	public InvalidNameException(String errorMessage){
		/**
		*<p>
		*The super constructor returns the errorMessage.
		*/
		super(errorMessage);
	}
}