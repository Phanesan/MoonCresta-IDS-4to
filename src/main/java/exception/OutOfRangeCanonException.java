package main.java.exception;

public class OutOfRangeCanonException extends Exception{
	
	public OutOfRangeCanonException() {
		super("No puedes subir o bajar de tier mas de lo establecido");
	}
	
}
