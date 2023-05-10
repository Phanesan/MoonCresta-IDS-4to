package main.java.graphics;

import java.awt.image.BufferedImage;

import main.java.Drawable;
import main.java.Updateable;
import main.java.Vector2D;
import main.java.state.GameState;

public abstract class MovingObject extends GameObject implements Updateable,Drawable {

	public final float SPEED;
	public final int MAX_HEALTH;
	public int HEALTH;
	
	public MovingObject(GameState gameState, BufferedImage texture, Vector2D position, float speed, int MAX_HEALTH) {
		super(gameState, texture, position);
		this.SPEED = speed;
		this.MAX_HEALTH = MAX_HEALTH;
		this.HEALTH = MAX_HEALTH;
	}
	
	public void updateCollision() {
		hitBox.x = (int) getPosition().x;
		hitBox.y = (int) getPosition().y;
	}
	
}
