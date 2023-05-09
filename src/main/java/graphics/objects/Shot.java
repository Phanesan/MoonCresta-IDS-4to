package main.java.graphics.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.java.Vector2D;
import main.java.graphics.MovingObject;

public class Shot extends MovingObject {

	public Shot(BufferedImage texture, Vector2D position, int speed) {
		super(texture, position, speed);
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(TEXTURE, (int)getPosition().x - TEXTURE.getWidth()/2, (int)getPosition().y - TEXTURE.getHeight(), null);
	}

	@Override
	public void update() {
		getPosition().y -= SPEED;
	}

}
