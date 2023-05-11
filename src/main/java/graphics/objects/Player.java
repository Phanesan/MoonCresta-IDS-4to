package main.java.graphics.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.java.Collisionable;
import main.java.Drawable;
import main.java.Key;
import main.java.Sound;
import main.java.Updateable;
import main.java.Vector2D;
import main.java.exception.OutOfRangeCanonException;
import main.java.graphics.Assets;
import main.java.graphics.GameObject;
import main.java.graphics.MovingObject;
import main.java.state.GameState;

public class Player extends MovingObject implements Updateable,Drawable,Collisionable{
	
	private double lastTime, time;
	public static int SHOOT_SPEED = 450;
	public int CANON_TIER = 1;
	public static int score = 0;
	private boolean isDeath;
	
	public Player(GameState gameState, BufferedImage texture, Vector2D position, int speed, int MAX_HEALTH) {
		super(gameState, texture, position, speed, MAX_HEALTH);
		time = 0;
		lastTime = System.currentTimeMillis();
		isDeath = false;
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
			Sound shotSound = new Sound(Assets.SHOT_LASER);
			shotSound.setVolume(-20f);
			shotSound.start();
			switch(CANON_TIER) {
				case 1:
					gameState.getHandler().add(new Shot(gameState, Assets.SHOT, getCenter(), 12, 1));
					break;
				case 2:
				case 3:
					Vector2D center = getCenter();
					Vector2D shotLeft = new Vector2D(center.x-20,center.y);
					Vector2D shotRight = new Vector2D(center.x+20,center.y);
					Shot shotL = new Shot(gameState, Assets.SHOT, shotLeft, 12, 1);
					Shot shotR = new Shot(gameState, Assets.SHOT, shotRight, 12, 1);
					gameState.getHandler().add(shotL);
					gameState.getHandler().add(shotR);
					
					break;
			}
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
					try {
						downgradeCanon();
						System.out.println("downgrade");
					} catch (OutOfRangeCanonException e) {
						System.out.println("muerto");
						Sound death = new Sound(Assets.DEATH);
						death.setVolume(-10f);
						death.start();
						kill(false);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(TEXTURE, (int)getPosition().x, (int)getPosition().y, null);
	}
	
	public void upgradeCanon() throws OutOfRangeCanonException{
		if(CANON_TIER < 3) {
			SHOOT_SPEED-=150; 
			CANON_TIER++;
			Sound upgrade = new Sound(Assets.UPGRADE);
			upgrade.setVolume(-10f);
			upgrade.start();
		} else
			throw new OutOfRangeCanonException();
	}
	
	public void downgradeCanon() throws OutOfRangeCanonException{
		if(CANON_TIER > 1) {
			SHOOT_SPEED+=150;
			CANON_TIER--;
			Sound downgrade = new Sound(Assets.DOWNGRADE);
			downgrade.setVolume(-10f);
			downgrade.start();
		} else
			throw new OutOfRangeCanonException();
	}

	@Override
	public void onDeath() {
		gameState.isDeath = true;
	}
}
