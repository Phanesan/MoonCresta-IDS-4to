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
//		this.hitBox.width = dimension.width;
//		this.hitBox.height = dimension.height;
	}

	public boolean isCollition(Vector2D newPosition, Player player) {
		ArrayList<MovingObject> movingObject = gameState.getHandler();
		for(int i = 0; i < movingObject.size(); i++) {
			MovingObject obj = movingObject.get(i);
			if(obj instanceof Player) {
				Rectangle posTemp = new Rectangle((int) newPosition.x,(int) newPosition.y,obj.hitBox.width,hitBox.height);
				if(posTemp.intersects(hitBox)) {
					return true;
				}
			}
		}
		return false;
	}

}
