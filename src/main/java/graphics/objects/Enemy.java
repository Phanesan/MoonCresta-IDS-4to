package main.java.graphics.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.java.Collisionable;
import main.java.Drawable;
import main.java.Updateable;
import main.java.Vector2D;
import main.java.WindowFrame;
import main.java.graphics.Assets;
import main.java.graphics.GameObject;
import main.java.graphics.MovingObject;
import main.java.state.GameState;

public class Enemy extends MovingObject implements Updateable,Drawable,Collisionable{
	
	private int FPS = 0;
	
	public Enemy(GameState gameState, BufferedImage texture, Vector2D position, float speed, int MAX_HEALTH) {
		super(gameState, texture, position, speed, MAX_HEALTH);
	}

	@Override
	public void update() {
		collidesWith();
		updateCollision();
		getPosition().y+=SPEED;
		
		FPS++;
		if(FPS >= WindowFrame.FPS_TARGET*3) {
			
			gameState.getHandler().add(new ShotEnemy(gameState, Assets.SHOT_ENEMY, getCenter(), 6, 1));
			
			FPS = 0;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(TEXTURE, (int)getPosition().x, (int)getPosition().y, null);
		
	}

	@Override
	public void collidesWith() {
		
	}

}
