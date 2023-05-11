package main.java.graphics.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.java.Collisionable;
import main.java.Drawable;
import main.java.Updateable;
import main.java.Vector2D;
import main.java.graphics.MovingObject;
import main.java.state.GameState;

public class Shot extends MovingObject implements Updateable,Drawable,Collisionable {
	
	public Shot(GameState gameState, BufferedImage texture, Vector2D position, int speed, int MAX_HEALTH) {
		super(gameState, texture, position, speed, MAX_HEALTH);
		position.x -= texture.getWidth()/2;
		position.y -= TEXTURE.getHeight();
		hitBox.x = (int)getPosition().x - TEXTURE.getWidth()/2;
		hitBox.y = (int)getPosition().y - TEXTURE.getHeight();
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(TEXTURE, (int)position.x, (int)position.y, null);
	}

	@Override
	public void update() {
		position.y -= SPEED;
		collidesWith();
		if(position.y < -30) {
			kill();
		}
		updateCollision();
	}
	
	@Override
	public void collidesWith() {
		ArrayList<MovingObject> movingObject = gameState.getHandler();
		for(int i = 0; i < movingObject.size(); i++) {
			MovingObject obj = movingObject.get(i);
			if(hitBox.intersects(obj.hitBox) && !(obj instanceof Shot) && !(obj instanceof Player)) {
				if(obj instanceof Enemy) {
					
					obj.HEALTH-=25;
					
					if(obj.HEALTH <= 0) {						
						obj.kill();
					}
					
					kill();
				}
			}
		}
	}

	@Override
	public void onDeath() {
		// TODO Auto-generated method stub
		
	}
}
