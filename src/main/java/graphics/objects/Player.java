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
	public static final int SHOOT_SPEED = 450;
	
	public Player(GameState gameState, BufferedImage texture, Vector2D position, int speed, int MAX_HEALTH) {
		super(gameState, texture, position, speed, MAX_HEALTH);
		time = 0;
		lastTime = System.currentTimeMillis();
	}

	@Override
	public void update() {
		time += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		if(Key.LEFT) {
			ArrayList<Wall> handler = gameState.getWallHandler();
			for(int i = 0; i < handler.size(); i++) {
				Vector2D newPosition = new Vector2D(getPosition().x,getPosition().y);
				newPosition.minusX(SPEED);
				boolean flag = handler.get(i).isCollition(newPosition, this);
				if(!flag) {
					getPosition().minusX(SPEED);					
				}
			}
		}
		if(Key.RIGHT) {
			ArrayList<Wall> handler = gameState.getWallHandler();
			for(int i = 0; i < handler.size(); i++) {
				Vector2D newPosition = new Vector2D(getPosition().x,getPosition().y);
				newPosition.addX(SPEED);
				boolean flag = handler.get(i).isCollition(newPosition, this);
				if(!flag) {
					getPosition().addX(SPEED);					
				}
			}
		}
		if(Key.SPACE && time > SHOOT_SPEED) {
			gameState.getHandler().add(new Shot(gameState, Assets.SHOT, getCenter(), 12, 1));
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
