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
	private Map<String,String> shorthand;
	
	public ArgsParser(){
		arguments = new HashMap<String,Argument>();
		shorthand = new HashMap<String,String>();
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
		addNamedArgument("--help","gets help message",Argument.Type.BOOLEAN,"false","-h");
	}
	
	public void addNamedArgument(String name, String description, Argument.Type t,String defaultvalue,String Shorthand){
		namedArgumentsNames.add(name);
		arguments.put(name,new namedArgument(t,description));
		arguments.get(name).setValue(defaultvalue);
		shorthand.put(Shorthand,name);
		
	}
	
	public void addPositionalArgument(String name, String description, Argument.Type t){
		positionalargumentNames.add(name);
		arguments.put(name,new positionalArgument(t,description));
		setPremessage();
	}
	
	
	public void parseValues (String[] values){
		parse(values);
		
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
	
	public String getErrorMessage(){
		return errorMessage;
	}
	
	public boolean getError(){
		return error;
	}
	
	public Argument.Type getArgumentType(String name){
		return arguments.get(name).getType();
	}

	
	
	private void parse(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		for(int i = 0; i < args.length; i++) {
			queue.add(args[i]);
		}
		while(!queue.isEmpty()) {
			String arg = queue.remove();
			if(arg.startsWith("-")) {
				// named argument
				if (arg.equals("--help")||arg.equals("-h")){
					arguments.get("--help").setValue("true");
					setHelpMessage();
					throw new HelpMessageException(helpMessage);
				}
				Argument a = arguments.get(arg);
				if(a == null) a = arguments.get(shorthand.get(arg));
				if(a != null) {
					if(a.getType() == Argument.Type.BOOLEAN) {
						a.setValue("true");
					}
					else {
						String val = queue.remove(); // What if I pull from an empty queue? Probably should be a NotEnoughArgumentsException or something.
						try {
							a.setValue(val);
						}
						catch(NumberFormatException ex){
							if(a.getType() == Argument.Type.INTEGER){
								errorMessage = premessage+"\n"+programName+".java: error: argument "+arg+": invalid int value: "+val;
								error = true;
							}
							else{
								errorMessage = premessage+"\n"+programName+".java: error: argument "+arg+": invalid double value: "+val;
								error = true;
							}
							throw new WrongFormatException(errorMessage);
						}
					}
				}
				else {
					errorMessage = premessage+"\n"+programName+".java: error: "+arg+" is not an argument";
					throw new NoSuchArgumentException(errorMessage);
				}
			}
			else {
				// positional argument
				
				if( positionalvaluesparsed==positionalargumentNames.size()){
					errorMessage = premessage+"\n"+programName+".java: error: unrecognized arguments: "+arg;
					error=true;
					throw new TooManyArgumentsException(errorMessage);
				} 
				String pname = positionalargumentNames.get(positionalvaluesparsed);
				positionalvaluesparsed++;
				Argument a = arguments.get(pname);
				try {
					a.setValue(arg);
				}
				catch(NumberFormatException ex){
					if(a.getType() == Argument.Type.INTEGER){
						errorMessage = premessage+"\n"+programName+".java: error: argument "+positionalargumentNames.get(positionalvaluesparsed-1)+": invalid int value: "+arg;
						error = true;
					}
					else{
						errorMessage = premessage+"\n"+programName+".java: error: argument "+positionalargumentNames.get(positionalvaluesparsed-1)+": invalid double value: "+arg;
						error = true;
					}
					throw new WrongFormatException(errorMessage);
				}
				catch(WrongFormatException ex){
					errorMessage = premessage+"\n"+programName+".java: error: argument "+positionalargumentNames.get(positionalvaluesparsed-1)+": invalid boolean value: "+arg;
					error = true;
					throw new WrongFormatException(errorMessage);
					
				}
			}
		}
		for(int i = 0; i < positionalargumentNames.size();i++)
			if (arguments.get(positionalargumentNames.get(i)).getValue().equals("")){
						errorMessage = premessage+"\n"+programName+".java: error: the following arguments are required: ";
						for(int j=i;j<positionalargumentNames.size();j++)
							errorMessage+=positionalargumentNames.get(j)+" ";
							error=true;
							throw new TooFewArgumentsException(errorMessage);
						}
		
	}
	
	
	
	
	
	
	
}