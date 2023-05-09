package main.java.graphics;

import java.awt.image.BufferedImage;

import main.java.Drawable;
import main.java.Updateable;
import main.java.Vector2D;

public abstract class MovingObject extends GameObject implements Updateable,Drawable {

	public final int SPEED;
	
	public MovingObject(BufferedImage texture, Vector2D position, int speed) {
		super(texture, position);
		this.SPEED = speed;
	}
	
}
