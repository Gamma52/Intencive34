package ru.aston.tarakanov_aa.task1.Exception;

public class SetPriceException extends Exception{
	
	private final CodeException code;
	
    public SetPriceException(String message, CodeException code) {
    	super(message);
    	this.code = code;		
    }

	public CodeException getCode() {
		return code;
	} 
	
	@Override
	public String toString() {
		return "Code Exception " + code + " \nMessage Exception " + getMessage();
	}
}
