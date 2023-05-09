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

	public Shot(GameState gameState, BufferedImage texture, Vector2D position, int speed) {
		super(gameState, texture, position, speed);
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(TEXTURE, (int)getPosition().x - TEXTURE.getWidth()/2, (int)getPosition().y - TEXTURE.getHeight(), null);
	}
	
	@Override
	public void updateCollision() {
		hitBox.x = (int)getPosition().x - TEXTURE.getWidth()/2;
		hitBox.y = (int)getPosition().y - TEXTURE.getHeight();
	}

	@Override
	public void update() {
		getPosition().y -= SPEED;
		collidesWith();
		if(getPosition().y < -30) {
			kill();
		}
		updateCollision();
	}
	
	@Override
	public void collidesWith() {
		ArrayList<MovingObject> movingObject = gameState.getHandler();
		for(int i = 0; i < movingObject.size(); i++) {
			if(hitBox.intersects(movingObject.get(i).hitBox) && !(movingObject.get(i) instanceof Shot) && !(movingObject.get(i) instanceof Player)) {
				if(movingObject.get(i) instanceof Enemy) {
					kill();
					movingObject.get(i).kill();
				}
			}
		}
	}
}
