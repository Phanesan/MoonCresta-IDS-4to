package main.java.state;

import java.awt.Graphics;

import main.java.Drawable;
import main.java.Updateable;

public abstract class State implements Updateable,Drawable{
	
	public static State currentState;
	
	@Override
	public abstract void draw(Graphics g);

	@Override
	public abstract void update();
	
	public static void changeState(State state) {
		currentState = state;
	}
	
}
