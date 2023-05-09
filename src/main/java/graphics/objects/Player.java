package main.java.graphics.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.java.Drawable;
import main.java.Key;
import main.java.Updateable;
import main.java.Vector2D;
import main.java.graphics.GameObject;
import main.java.graphics.MovingObject;

public class Player extends MovingObject implements Updateable,Drawable{
	
	public Player(BufferedImage texture, Vector2D position, int speed) {
		super(texture, position, speed);
	}

	@Override
	public void update() {
		if(Key.LEFT) {
			getPosition().minusX(SPEED);
		}
		if(Key.RIGHT) {
			getPosition().addX(SPEED);
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(TEXTURE, (int)getPosition().x, (int)getPosition().y, null);
	}

}
