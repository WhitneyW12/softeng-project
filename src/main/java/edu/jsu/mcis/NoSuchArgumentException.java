package edu.jsu.mcis;
import java.util.*;
public class NoSuchArgumentException extends RuntimeException{

	public NoSuchArgumentException(String errorMessage){
		super(errorMessage);
	}
}