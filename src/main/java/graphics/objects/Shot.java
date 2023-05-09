package main.java.graphics.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.java.Vector2D;
import main.java.graphics.MovingObject;
import main.java.state.GameState;

public class Shot extends MovingObject {

	public Shot(GameState gameState, BufferedImage texture, Vector2D position, int speed) {
		super(gameState, texture, position, speed);
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(TEXTURE, (int)getPosition().x - TEXTURE.getWidth()/2, (int)getPosition().y - TEXTURE.getHeight(), null);
	}

	@Override
	public void update() {
		getPosition().y -= SPEED;
	}

	@Override
	public void triggerCollition(MovingObject movingObject) {
		// TODO Auto-generated method stub
		if(movingObject instanceof Enemy) {
			kill();
			movingObject.kill();
		}
	}

}
