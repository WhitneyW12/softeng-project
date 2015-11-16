package edu.jsu.mcis;
import java.util.*;
public class InvalidNameException extends RuntimeException{

	public InvalidNameException(String errorMessage){
		super(errorMessage);
	}
}