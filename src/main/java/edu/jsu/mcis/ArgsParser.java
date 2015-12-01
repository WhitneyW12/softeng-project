
package edu.jsu.mcis;
import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * This program allows the user to add arguments and enter data values into them from the command line.
 * this is an example of how to use this class 
 * in the example the string array args would be replaced with th comandline arguments taken form the user
 * 		private ArgsParser ap = new ArgsParser();
 *		String[] args = new String[] {"7"};
 *		ap.addProgram("VolumeCalculator","Calculate the volume of a box");
 *		ap.addPositionalArgument("length","the length of the box",Argument.Type.STRING);
 *		ap.addNamedArgument("digits","prints help message",Argument.Type.INTEGER,"4","d");
 *		ap.parseValues(args);
 * after the block of code excutes the value stored in the argument length would be  "7" and the value of digits would be 4.
 * to obtain the values from this class use the getValue function like so 
 * 		ap.getValue("length")
 * this would return a 7 if using the above example
 * the user can alos get the data type of any given argumnet by using getArgumentType
 * for length it would return string use like so
 *		ap.getArgumentType("length")
 *
 *@author BabaTunde Idumu
 *@author Michael Quattrochi
 *@author Wesley Schultz
 *@author James Thomas
 *@author Whitney Wood
 */
public class ArgsParser{
	private List<String> positionalargumentNames;
	private List<String> namedArgumentsNames;
	private Map<String,Argument> arguments;
	private String premessage;
	private String programName;
	private String XMLData;
	private String programDescription;
	private String errorMessage;
	private boolean error;
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
		premessage = "";
		XMLData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
					"<program>\n";  
		errorMessage = "";
		error = false;
		numofNamedArgValues = 0;
		positionalvaluesparsed = 0;
	}
	
	/**
	 *This method adds a named argument to the program.
	 *
	 *@param name The name of the argument.
	 *@param description The description of the argument.
	 *@param t The data type of the argument(String, Integer, Double, Boolean).
	 *@param defaultvalue The default value of the argument.
	 *@param Shorthand The one letter short name of the argument.
	 *@throws InvalidNameException
	 */
	public void addNamedArgument(String name, String description, Argument.Type t,String defaultvalue,String Shorthand){
		if(Shorthand.length()>1){
			throw new InvalidNameException(Shorthand +" is an invalid name");
		}
		namedArgumentsNames.add(name);
		arguments.put("--"+name,new namedArgument(t,description));
		arguments.get("--"+name).setValue(defaultvalue);
		shorthand.put("-"+Shorthand,"--"+name);
		XMLData += "<namedArgument>\n" + "<name>" + name + "</name>\n" + 
		"<type>" + t + "</type>\n" + "<description>" + description + "</description>\n"
		 + "<default>" + defaultvalue + "</default>\n" + "<shorthand>" + Shorthand + "</shorthand>\n</namedArgument>\n";	
	}
	
	/**
	 *This method adds a positional argument to the program.
	 *
	 *@param name The name of the argument.
	 *@param description The description of the argument.
	 *@param t The data type of the argument(String, Integer, Double, Boolean).
	 */
	public void addPositionalArgument(String name, String description, Argument.Type t){
		positionalargumentNames.add(name);
		arguments.put(name,new positionalArgument(t,description));
		setPremessage();
		XMLData += "<positionalArgument>\n" + "<name>" + name + "</name>\n" + 
		"<type>" + t + "</type>\n" + "<description>" + description + "</description>\n</positionalArgument>\n";
	}
	/**
	 *This method takes in the argument values from the user's program and assignes them to the appropriate argument.
	 *
	 *@param  values string array of the values.
	 *@throws HelpMessageException
	 *@throws WrongFormatException
	 *@throws NoSuchArgumentException
	 *@throws TooManyArgumentsException
	 *@throws TooFewArgumentsException
	 */
	public void parseValues (String[] values){
		parse(values);
	}
	
	/**
	 *This method adds a program.
	 *
	 *@param name The name of the program.
	 *@param description The description of the program.
	 */
	public void addProgram(String name,String description){
		programName = name;
		programDescription = description;
		setPremessage();
		XMLData += "<name>" + name + "</name>\n" + "<description>" + description + "</description>\n" +"<arguments>\n";
	}
	
	/**
	 *This method returns the description of an argument.
	 *
	 *@param name The name of the arument to get the description of.
	 *@return The description of the argument.
	 */
	public String getDescription(String name){
		return arguments.get(name).getDescription();
	}
	
	/**
	 *This method sets the help message of the program.
	 */
	private void setHelpMessage(){
		errorMessage = premessage;
		errorMessage += "\n"+programDescription+"\npositional arguments:\n";
		for(int i =0; i<positionalargumentNames.size();i++){
			errorMessage += positionalargumentNames.get(i)+" "+arguments.get(positionalargumentNames.get(i)).getDescription()+"\n";
		}
		if(namedArgumentsNames.size()!=0){
			errorMessage += "Named arguments:\n";
			for(int i =0; i<namedArgumentsNames.size();i++){
				errorMessage += namedArgumentsNames.get(i)+" "+arguments.get("--"+namedArgumentsNames.get(i)).getDescription()+" "+arguments.get("--"+namedArgumentsNames.get(i)).getType()+"\n";
			}
		}
	 }
	
	/**
	 *This method sets the premessage for all of the exceptions.
	 */
	private void setPremessage(){
		premessage = "usage: java "+programName+" ";
		for (int i=0; i<positionalargumentNames.size();i++){
			premessage += positionalargumentNames.get(i)+" ";
		}
	}
	
	/**
	 *This method returns the value of the argument.
	 *
	 *@param name The name of the argument.
	 *@return The value.
	 */
	public <T> T getValue(String name){
		if(namedArgumentsNames.contains(name)){
			return (T)arguments.get("--"+name).getValue();
		}
		return (T)arguments.get(name).getValue();
	}
	
	/**
	 *This method returns the error message.
	 *@return The error message.
	 */
	public String getErrorMessage(){
		return errorMessage;
	}
	
	/**
	 *This method returns if true an error has happened.
	 *@return The error.
	 */
	public boolean getError(){
		return error;
	}
	
	/**
	 *This method returns the type of the argument {INTEGER,STRING,DOUBLE,BOOLEAN}.
	 *@return The type.
	 */
	public Argument.Type getArgumentType(String name){
		return arguments.get(name).getType();
	}
	
	/**
	 *This method saves the program and its arguments to an XML file.
	 *
	 *@param filepath The filepath of the file to be saved.
	 *@throws HelpMessageException
	 */
	public void saveXML(String filepath){
		XMLData+= "</arguments>\n</program>";
		File outfile = new File(filepath);	
		try{
		Writer writer = new BufferedWriter(new OutputStreamWriter(
		new FileOutputStream(outfile), "utf-8")); 
		writer.write(XMLData);
		writer.close();
		}
		catch(IOException e){
			throw new HelpMessageException("");
		}
		
		
	}
	private void parse(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		for(int i = 0; i < args.length; i++) {
			queue.add(args[i]);
		}
		while(!queue.isEmpty()) {
			 
				
			
			String arg = queue.remove();
			if(arg.startsWith("-")) {
				if (arg.equals("--help")||arg.equals("-h")){
					setHelpMessage();
					error = true;
					throw new HelpMessageException(errorMessage);
				}
				Argument a = arguments.get(arg);
				if(a == null) a = arguments.get(shorthand.get(arg));
				if(a != null) {
					if(a.getType() == Argument.Type.BOOLEAN) {
						a.setValue("true");
					}
					else {
						String val = queue.remove(); 
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