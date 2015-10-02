package edu.jsu.mcis;
import java.util.*;



public class TooManyArgumentsException extends RuntimeException{
	
	public TooManyArgumentsException(String errorMessage){
		super(errorMessage);
	}
}
