package main.java.graphics.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.java.Drawable;
import main.java.Key;
import main.java.Updateable;
import main.java.Vector2D;
import main.java.graphics.Assets;
import main.java.graphics.GameObject;
import main.java.graphics.MovingObject;
import main.java.state.GameState;

public class Player extends MovingObject implements Updateable,Drawable{
	
	private double lastTime, time;
	public int shotSpeed;
	
	public Player(GameState gameState, BufferedImage texture, Vector2D position, int speed) {
		super(gameState, texture, position, speed);
		time = 0;
		lastTime = System.currentTimeMillis();
		shotSpeed = 250;
	}

	@Override
	public void update() {
		time += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		if(Key.LEFT) {
			getPosition().minusX(SPEED);
		}
		if(Key.RIGHT) {
			getPosition().addX(SPEED);
		}
		if(Key.SPACE && time > shotSpeed) {
			gameState.getHandler().add(new Shot(gameState, Assets.SHOT, getCenter(), 12));
			time = 0;
		}
		collidesWith();
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(TEXTURE, (int)getPosition().x, (int)getPosition().y, null);
	}

	@Override
	public void triggerCollition(MovingObject movingObject) {
		// TODO Auto-generated method stub
		if(movingObject instanceof Enemy ) {
			kill();
		}
	}

}
