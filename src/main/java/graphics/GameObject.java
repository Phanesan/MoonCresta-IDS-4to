package main.java.graphics;

import java.awt.image.BufferedImage;

import main.java.Drawable;
import main.java.Updateable;
import main.java.Vector2D;

public abstract class GameObject {
	
	public final BufferedImage TEXTURE;
	private Vector2D position;
	
	public GameObject(BufferedImage texture, Vector2D position) {
		this.TEXTURE = texture;
		this.position = position;
	}

	public Vector2D getPosition() {
		return position;
	}

	public void setPosition(Vector2D position) {
		this.position = position;
	}
	
	public Vector2D getCenter() {
		return new Vector2D(position.x+TEXTURE.getWidth()/2,position.y+TEXTURE.getHeight()/2);
	}
	
}
