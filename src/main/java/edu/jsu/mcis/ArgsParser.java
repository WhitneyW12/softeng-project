package edu.jsu.mcis;

import java.util.*;
import java.lang.*;

public class ArgsParser{
	private List<String> positionalargumentNames;
	private List<String> namedArgumentsNames;
	private Map<String,Argument> arguments;
	private String premessage;
	private String helpMessage;
	private String programName;
	private String programDescription;
	private String errorMessage;
	private boolean error;
	private boolean help;
	private int numofNamedArgValues;
	private int positionalvaluesparsed;
	
	public ArgsParser(){
		arguments = new HashMap<String,Argument>();
		namedArgumentsNames = new ArrayList<String>();
		positionalargumentNames= new ArrayList<String>();
		programName = "";
		programDescription = "";
		helpMessage = "";
		premessage = "";
		errorMessage = "";
		error = false;
		help = false;
		numofNamedArgValues = 0;
		positionalvaluesparsed = 0;
		addNamedArgument("--help","gets help message",Argument.Type.BOOLEAN,false,"-h");
	}
	
	public void addNamedArgument(String name, String description, Argument.Type t,Object defaultvalue,String Shorthand){
		namedArgumentsNames.add(name);
		arguments.put(name,new namedArgument(t,description));
		arguments.get(name).setValue(defaultvalue);
		arguments.get(name).setShorthand(Shorthand);
		
	}
	
	public void addPositionalArgument(String name, String description, Argument.Type t){
		positionalargumentNames.add(name);
		arguments.put(name,new positionalArgument(t,description));
		setPremessage();
	}
	
	
	public void parseValues (String[] values){
		//parse(values);
		
		for(int i=0;i<values.length;i++){
			help = false;
			if(values[i].substring(0,1).equals("-")){
				i = parseNamedArguments(i, values);
			}
			if(!help){
				checkForLengthOfArgumentExceptions(i, values);
			}
			parsePositionalArguments(i, values);
		}
		
	}
	
	private void parsePositionalArguments(int i, String[] values){
		if(i<values.length&&positionalvaluesparsed<positionalargumentNames.size()){
				positionalvaluesparsed++;
				if(arguments.get(positionalargumentNames.get(positionalvaluesparsed-1)).getType()==Argument.Type.STRING){
					arguments.get(positionalargumentNames.get(positionalvaluesparsed-1)).setValue(values[i]);
				}
				else if(arguments.get(positionalargumentNames.get(positionalvaluesparsed-1)).getType()==Argument.Type.DOUBLE){
					try{
						parseDouble(positionalvaluesparsed-1,values[i]);
					}
					catch(NumberFormatException e){
						errorMessage = premessage+"\n"+programName+".java: error: argument "+positionalargumentNames.get(i)+": invalid double value: "+values[i];
						error = true;
						throw new WrongFormatException(errorMessage);
					}
				}
				else if(arguments.get(positionalargumentNames.get(positionalvaluesparsed-1)).getType()==Argument.Type.INTEGER){
					try{
					parseInteger(positionalvaluesparsed-1,values[i]);
					}
					catch(NumberFormatException e){
						errorMessage = premessage+"\n"+programName+".java: error: argument "+positionalargumentNames.get(i)+": invalid int value: "+values[i];
						error = true;
						throw new WrongFormatException(errorMessage);
					}
				}
				else{
					if(values[i].equals("false")||values[i].equals("true")){
						parseBoolean(positionalvaluesparsed-1,values[i]);
					}
					else{
						errorMessage = premessage+"\n"+programName+".java: error: argument "+positionalargumentNames.get(i)+": invalid boolean value: "+values[i];
						error = true;
						throw new WrongFormatException(errorMessage);
					}
				}
			}
	}
	private void checkForLengthOfArgumentExceptions(int i, String[] values){
				if( positionalvaluesparsed==positionalargumentNames.size()){
					errorMessage = premessage+"\n"+programName+".java: error: unrecognized arguments: "+values[i];
					error=true;
					throw new TooManyArgumentsException(errorMessage);
				} 
				else if (values.length < positionalargumentNames.size()&& i==values.length-1){
					errorMessage = premessage+"\n"+programName+".java: error: the following arguments are required: ";
					for(int j=i+1;j<positionalargumentNames.size();j++)
						errorMessage+=positionalargumentNames.get(j)+" ";
						error=true;
						throw new TooFewArgumentsException(errorMessage);
					}
				}

	public void addProgram(String name,String description){
		programName = name;
		programDescription = description;
		setPremessage();
	}
	
	public String getDescription(String name){
		return arguments.get(name).getDescription();
	}
	
	private void setHelpMessage(){
		helpMessage = premessage;
		helpMessage += "\n"+programDescription+"\npositional arguments:\n";
		for(int i =0; i<positionalargumentNames.size();i++){
			helpMessage += positionalargumentNames.get(i)+" "+arguments.get(positionalargumentNames.get(i)).getDescription()+"\n";
		}
	}
	
	private void setPremessage(){
		premessage = "usage: java "+programName+" ";
		for (int i=0; i<positionalargumentNames.size();i++){
			premessage += positionalargumentNames.get(i)+" ";
		}
	}  
	
	public String getHelpMessage(){
		setHelpMessage();
		return helpMessage;
	}

	public <T> T getValue(String name){
		return (T)arguments.get(name).getValue();
	}
	
	private void parseDouble(int index,String value)throws NumberFormatException{
		arguments.get(positionalargumentNames.get(index)).setValue(Double.parseDouble(value));
	}
	
	private void parseInteger(int index,String value)throws NumberFormatException{
		arguments.get(positionalargumentNames.get(index)).setValue(Integer.parseInt(value));
	}
	
	private void parseBoolean(int index,String value){
		arguments.get(positionalargumentNames.get(index)).setValue(Boolean.parseBoolean(value));
	}
	private void parseNamedDouble(int index,String value)throws NumberFormatException{
		arguments.get(namedArgumentsNames.get(index)).setValue(Double.parseDouble(value));
	}
	
	private void parseNamedInteger(int index,String value)throws NumberFormatException{
		arguments.get(namedArgumentsNames.get(index)).setValue(Integer.parseInt(value));
	}
	
	public String getErrorMessage(){
		return errorMessage;
	}
	
	public boolean getError(){
		return error;
	}
	
	public Argument.Type getArgumentType(String name){
		return arguments.get(name).getType();
	}

	
	
	/*private void parse(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		for(int i = 0; i < args.length; i++) {
			queue.add(args[i]);
		}
		while(!queue.isEmpty()) {
			String arg = queue.remove();
			if(arg.startsWith("-")) {
				// named argument
				Argument a = arguments.get(arg);
				if(a == null) a = shorthand.get(arg);
				if(a != null) {
					if(a.getType() == Argument.Type.BOOLEAN) {
						a.setValue(true);
					}
					else {
						String val = queue.remove(); // What if I pull from an empty queue? Probably should be a NotEnoughArgumentsException or something.
						try {
							a.setValue(val);
						}
						catch(Exception e) {
							
						}
					}
				}
				else {
					throw new NoSuchArgumentException();
				}
			}
			else {
				// positional argument
				String pname = positionalargumentNames.get(positionalvaluesparsed);
				positionalvaluesparsed++;
				Argument a = arguments.get(pname);
				try {
					a.setValue(arg);
				}
				catch(ExceptionA e) {
					//throw new 
				}
				catch(ExceptionB e) {
					
				}
			}
		}
		
	}*/
	
	
	
	private int parseNamedArguments(int i, String[] values){
		boolean b = false;
		boolean found= false;
		for(int j=0;j<namedArgumentsNames.size()&&i<values.length;j++){
			if(values[i].substring(0,1).equals("-")){
				found=false;
				if(values[i].equals(namedArgumentsNames.get(j)) || values[i].equals(arguments.get(namedArgumentsNames.get(j)).getShorthand())){	
					found=true;
					if(arguments.get(namedArgumentsNames.get(j)).getType()==Argument.Type.BOOLEAN){
					arguments.get(namedArgumentsNames.get(j)).setValue(true);
					if(values[i].equals("--help")||values[i].equals("-h")){
						b=getValue("--help");
					}
					i=i+1;
					help=true;
				
					}
				
					else{
						if(arguments.get(namedArgumentsNames.get(j)).getType()==Argument.Type.STRING){
						arguments.get(namedArgumentsNames.get(j)).setValue(values[i+1]);
						}
						else if(arguments.get(namedArgumentsNames.get(j)).getType()==Argument.Type.DOUBLE){
							try{
								parseNamedDouble(j,values[i+1]);
							}
							catch(NumberFormatException e){
								errorMessage = premessage+"\n"+programName+".java: error: argument "+positionalargumentNames.get(i)+": invalid double value: "+values[i];
								error = true;
								throw new WrongFormatException(errorMessage);
							}
						}
						else if(arguments.get(namedArgumentsNames.get(j)).getType()==Argument.Type.INTEGER){
							try{
							parseNamedInteger(j,values[i+1]);
							}
							catch(NumberFormatException e){
								errorMessage = premessage+"\n"+programName+".java: error: argument "+positionalargumentNames.get(i)+": invalid int value: "+values[i];
								error = true;
								throw new WrongFormatException(errorMessage);
							}
						}
						
						i+=2;	
					}	
					help=true;
				
					j=0;
				}
				
		}
		}
		if(!found){
			throw new NoSuchArgumentException("");
		}
		if(b){
				
				throw new HelpMessageException(helpMessage);	
			}
		return i;
	}
	
	
	
}