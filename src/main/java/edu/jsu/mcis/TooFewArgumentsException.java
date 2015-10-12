package edu.jsu.mcis;
import java.util.*;



public class TooFewArgumentsException extends RuntimeException{
	
	public TooFewArgumentsException(String errorMessage){
		super(errorMessage);
	}
}
