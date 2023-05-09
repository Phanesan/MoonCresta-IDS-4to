package main.java.graphics.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.java.Drawable;
import main.java.Updateable;
import main.java.Vector2D;
import main.java.graphics.MovingObject;

public class Shot extends MovingObject implements Updateable,Drawable{

	public Shot(BufferedImage texture, Vector2D position, int speed) {
		super(texture, position, speed);
	}

	@Override
	public void draw(Graphics g) {
		
	}

	@Override
	public void update() {
		
	}

}
