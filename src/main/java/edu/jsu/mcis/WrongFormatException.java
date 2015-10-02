package edu.jsu.mcis;
import java.util.*;
public class WrongFormatException extends RuntimeException{

	public WrongFormatException(String errorMessage){
		super(errorMessage);
	}
}