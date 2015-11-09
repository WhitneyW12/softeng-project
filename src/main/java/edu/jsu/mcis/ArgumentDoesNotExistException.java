package edu.jsu.mcis;
import java.util.*;

public class ArgumentDoesNotExistException extends RuntimeException{

	public ArgumentDoesNotExistException(String errorMessage){
		super(errorMessage);
	}
}