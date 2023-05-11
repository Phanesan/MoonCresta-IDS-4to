package main.java;

public abstract class Util {
	
	public static boolean randomBoolean(double probability) {
        return (Math.random()) < (probability/100);
    }
	
}
