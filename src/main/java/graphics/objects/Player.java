package main.java.graphics.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.java.Key;
import main.java.Vector2D;
import main.java.graphics.GameObject;

public class Player extends GameObject {
	
	private static final int speed = 10;
	
	public Player(BufferedImage texture, Vector2D position) {
		super(texture, position);
	}

	@Override
	public void update() {
		if(Key.LEFT) {
			getPosition().x-=speed;
		}
		if(Key.RIGHT) {
			getPosition().x+=speed;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(TEXTURE, (int)getPosition().x, (int)getPosition().y, null);
	}

}
