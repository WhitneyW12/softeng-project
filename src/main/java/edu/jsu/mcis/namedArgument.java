package edu.jsu.mcis;
public class namedArgument extends Argument{
	

	public namedArgument(Type type, String description){
		 super(type,description);
	 }
	 public String getDescription(){
		 /**
		*<p>
		*The getDescription returns the argument description.
		*/
		 return argumentDescription;
	 }
	 public Object getValue(){
		 /**
		*<p>
		*The getValue returns the argument value.
		*/
		 return argumentValue;
	 }
	 public Type getType(){
		 /**
		*<p>
		*The getType returns the argument type.
		*/
		 return argumentType;
	 }
	 
	 
	 
	 
	 
	}
	
	
