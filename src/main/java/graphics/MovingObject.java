package main.java.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.java.Vector2D;

public abstract class MovingObject extends GameObject {

	public final int SPEED;
	
	public MovingObject(BufferedImage texture, Vector2D position, int speed) {
		super(texture, position);
		this.SPEED = speed;
	}
	
}
