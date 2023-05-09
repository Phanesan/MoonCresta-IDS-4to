package main.java.state;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import main.java.Drawable;
import main.java.Sound;
import main.java.Updateable;
import main.java.Vector2D;
import main.java.graphics.Assets;
import main.java.graphics.MovingObject;
import main.java.graphics.objects.Enemy;
import main.java.graphics.objects.Player;
import main.java.graphics.objects.Shot;

public class GameState implements Updateable,Drawable{
	
	private Player player;
	private ArrayList <MovingObject> handler;
	private Sound background;
	
	public GameState() {
		handler = new ArrayList<>();
		player = new Player(this, Assets.PLAYER, new Vector2D(640, 640),7);
		handler.add(player);
		handler.add(new Enemy(this, Assets.ENEMY1, new Vector2D(200,200),0));
		
		background = new Sound(Assets.BACKGROUND_OST);
		background.loop(726000,7292000);
	}

	@Override
	public void draw(Graphics g) {
		for(int i = 0; i < handler.size(); i++) {
			handler.get(i).draw(g);
		}
	}

	@Override
	public void update() {
		for(int i = 0; i < handler.size(); i++) {
			handler.get(i).update();
		}
		background.update();
	}

	public ArrayList<MovingObject> getHandler() {
		return handler;
	}
	
}
