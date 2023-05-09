package main.java.graphics;

import java.awt.image.BufferedImage;

import main.java.Drawable;
import main.java.Updateable;
import main.java.Vector2D;
import main.java.state.GameState;

public abstract class MovingObject extends GameObject implements Updateable,Drawable {

	public final int SPEED;
	
	public MovingObject(GameState gameState, BufferedImage texture, Vector2D position, int speed) {
		super(gameState, texture, position);
		this.SPEED = speed;
	}
	
}
