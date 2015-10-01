package edu.jsu.mcis;
import java.util.*;



public class TooManyArgumentsException extends RunTimeException{
	
	public TooManyArgumentsException(String errorMessage){
		super(errorMessage);
	}
}
public class WrongFormatException extends RunTimeException{

	public WrongFormatException(String errorMessage){
		super(errorMessage);
	}
}