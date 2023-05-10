package main.java.graphics.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.java.Collisionable;
import main.java.Drawable;
import main.java.Updateable;
import main.java.Vector2D;
import main.java.graphics.MovingObject;
import main.java.state.GameState;

public class ShotEnemy extends MovingObject implements Updateable,Drawable,Collisionable{

	public ShotEnemy(GameState gameState, BufferedImage texture, Vector2D position, float speed, int MAX_HEALTH) {
		super(gameState, texture, position, speed, MAX_HEALTH);
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(TEXTURE, (int)getPosition().x - TEXTURE.getWidth()/2, (int)getPosition().y - TEXTURE.getHeight(), null);
	}

	@Override
	public void update() {
		getPosition().y += SPEED;
		collidesWith();
		if(getPosition().y < -30) {
			kill();
		}
		updateCollision();
	}
	
	@Override
	public void updateCollision() {
		hitBox.x = (int)getPosition().x - TEXTURE.getWidth()/2;
		hitBox.y = (int)getPosition().y - TEXTURE.getHeight();
	}

	@Override
	public void collidesWith() {
		ArrayList<MovingObject> movingObject = gameState.getHandler();
		for(int i = 0; i < movingObject.size(); i++) {
			MovingObject obj = movingObject.get(i);
			if(hitBox.intersects(obj.hitBox) && !(obj instanceof Shot) && !(obj instanceof Enemy)) {
				if(obj instanceof Player) {
					
					obj.HEALTH-=50;
					
					if(obj.HEALTH <= 0) {						
						obj.kill();
						// metodo game over <------------------------------
					}
					
					kill();
					
				}
			}
		}
	}

}
