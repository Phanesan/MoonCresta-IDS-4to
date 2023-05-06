package main.java;

public interface Moveable {
	
	public enum Direction {
		UP,
		DOWN,
		LEFT,
		RIGHT;
	}
	
	public void move(Direction direction);
	
}
