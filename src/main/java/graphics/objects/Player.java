package main.java.graphics.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.java.Collisionable;
import main.java.Drawable;
import main.java.Key;
import main.java.Updateable;
import main.java.Vector2D;
import main.java.graphics.Assets;
import main.java.graphics.GameObject;
import main.java.graphics.MovingObject;
import main.java.state.GameState;

public class Player extends MovingObject implements Updateable,Drawable,Collisionable{
	
	private double lastTime, time;
	public int shotSpeed;
	
	public Player(GameState gameState, BufferedImage texture, Vector2D position, int speed) {
		super(gameState, texture, position, speed);
		time = 0;
		lastTime = System.currentTimeMillis();
		shotSpeed = 450;
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
		updateCollision();
		collidesWith();
	}
	
	@Override
	public void collidesWith() {
		ArrayList<MovingObject> movingObject = gameState.getHandler();
		for(int i = 0; i < movingObject.size(); i++) {
			if(hitBox.intersects(movingObject.get(i).hitBox) && !(movingObject.get(i) instanceof Player)) {
				if(movingObject.get(i) instanceof Enemy) {
					kill();
				}
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(TEXTURE, (int)getPosition().x, (int)getPosition().y, null);
	}
}
