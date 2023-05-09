package main.java.graphics.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.java.Drawable;
import main.java.Updateable;
import main.java.Vector2D;
import main.java.graphics.GameObject;
import main.java.graphics.MovingObject;
import main.java.state.GameState;

public class Enemy extends MovingObject implements Updateable,Drawable{

	public Enemy(GameState gameState, BufferedImage texture, Vector2D position, int speed) {
		super(gameState, texture, position, speed);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void triggerCollition(MovingObject movingObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(TEXTURE, (int)getPosition().x, (int)getPosition().y, null);
	}

}
