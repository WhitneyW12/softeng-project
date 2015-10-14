package edu.jsu.mcis;
public class namedArgument extends Argument{
	private int numberOfValues;
	private Object[] argumentValues;
	private String shorthand;
	public namedArgument(Type type, String description, int numberOfValues){
		  super(type,description);
		 shorthand = "";
		 this.numberOfValues = numberOfValues;
		// argumentValues= new Object[numberOfValues];
		 
	 }
	 public void setShorthand(String s){
		 shorthand = s;
	 }
	 public String getShorthand(){
		 return shorthand;
	 }
	 //public void setValues(Object[] myarray){
		// for(int i=0;i<myarray.length;i++){
			// argumentValues[i]=myarray[i];
		 //}
		 
	 //}
	// public object[]{}
}
	
	
	
