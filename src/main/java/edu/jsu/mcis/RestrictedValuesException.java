package edu.jsu.mcis;
import java.util.*;

public class RestrictedValuesException extends RuntimeException{

	public RestrictedValuesException(String errorMessage){
		super(errorMessage);
	}
}