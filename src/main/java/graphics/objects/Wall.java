package main.java.graphics.objects;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.java.Collisionable;
import main.java.Updateable;
import main.java.Vector2D;
import main.java.graphics.GameObject;
import main.java.graphics.MovingObject;
import main.java.state.GameState;

public class Wall extends GameObject {

	public Wall(GameState gameState, Dimension dimension, Vector2D position) {
		super(gameState, dimension, position);
	}

	public boolean isCollition(Vector2D newPosition, Player player) {
		ArrayList<Wall> movingObject = gameState.getWallHandler();
		for(int i = 0; i < movingObject.size(); i++) {
			Wall obj = movingObject.get(i);
			Rectangle newHitBoxPlayer = new Rectangle((int)newPosition.x,(int)newPosition.y,player.hitBox.width,player.hitBox.height);
			if(newHitBoxPlayer.intersects(obj.hitBox)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void onDeath() {
	}

}
