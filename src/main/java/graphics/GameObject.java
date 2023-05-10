package main.java.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.java.Drawable;
import main.java.Updateable;
import main.java.Vector2D;
import main.java.state.GameState;

public abstract class GameObject {
	
	public final BufferedImage TEXTURE;
	private Vector2D position;
	public Rectangle hitBox;
	protected GameState gameState;
	
	public GameObject(GameState gameState, BufferedImage texture, Vector2D position) {
		this.gameState = gameState;
		this.TEXTURE = texture;
		this.position = position;
		hitBox = new Rectangle((int)position.x,(int)position.y,TEXTURE.getWidth(), TEXTURE.getHeight());
	}
	
	public GameObject(GameState gameState, Dimension dimension, Vector2D position) {
		this.gameState = gameState;
		this.TEXTURE = null;
		this.position = position;
		hitBox = new Rectangle((int)position.x,(int)position.y,dimension.width, dimension.height);
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
	
	public void kill() {
		gameState.getHandler().remove(this);
	}
	
	public void drawHitBox(Graphics g) {
		g.setColor(Color.YELLOW);
		g.drawRect(hitBox.x, hitBox.y, hitBox.width, hitBox.height);
	}
	
}
