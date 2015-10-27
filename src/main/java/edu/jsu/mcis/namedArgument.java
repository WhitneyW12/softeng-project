package edu.jsu.mcis;
public class namedArgument extends Argument{
	private int numberOfValues;
	private Object[] argumentValues;
	private boolean hasRestricted; 
	private Object argumentValue;
	private String shorthand;
	private String argumentDescription;

	public namedArgument(Type type, String description, int numberOfValues, String[] restrictedValues){
		 super(type,description,restrictedValues);
		 this.numberOfValues = numberOfValues;
		hasRestricted = false;
		numberOfValues=1;
	 }

	 public void setShorthand(String s){
		 shorthand = s;
	 }
	 public String getShorthand(){
		 return shorthand;
	 }
	 
	 public void setValue(Object value){
		 argumentValue = value;
	 }
	 public String getDescription(){
		 return argumentDescription;
	 }
	 public Object getValue(){
		 return argumentValue;
	 }
	 public Type getType(){
		 return argumentType;
	 }
	 public int getNumberOfValues(){
		 return numberOfValues;
	 }
	 
	 public void setHasRestricted(boolean b){
		 hasRestricted = b;
	 }
	 
	 public String[] getRestrictedValues(){
		 return restrictedValues;
	 }
	 
	 
	 //public void setValues(Object[] myarray){
		// for(int i=0;i<myarray.length;i++){
			// argumentValues[i]=myarray[i];
		 //}
		 
	 //}
	// public object[]{}
}
	
	
	
