package main.java.graphics.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.java.Drawable;
import main.java.Updateable;
import main.java.Vector2D;
import main.java.graphics.GameObject;

public class Enemy extends GameObject implements Updateable,Drawable{

	public Enemy(BufferedImage texture, Vector2D position) {
		super(texture, position);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void draw(Graphics g) {
		
	}

}
