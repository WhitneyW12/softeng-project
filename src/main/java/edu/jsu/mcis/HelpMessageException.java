package edu.jsu.mcis;
import java.util.*;

public class HelpMessageException extends RuntimeException{

	public HelpMessageException(String errorMessage){
		super(errorMessage);
	}
}