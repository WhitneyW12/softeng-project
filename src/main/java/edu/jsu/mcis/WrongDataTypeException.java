package edu.jsu.mcis;
import java.util.*;

public class WrongDataTypeException extends RuntimeException{

	public WrongDataTypeException(String errorMessage){
		super(errorMessage);
	}
}