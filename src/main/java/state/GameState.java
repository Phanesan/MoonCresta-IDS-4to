package main.java.state;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import main.java.Drawable;
import main.java.Updateable;
import main.java.Vector2D;
import main.java.graphics.Assets;
import main.java.graphics.MovingObject;
import main.java.graphics.objects.Player;
import main.java.graphics.objects.Shot;

public class GameState implements Updateable,Drawable{
	
	private Player player;
	private ArrayList <Shot> handler;
	
	public GameState() {
		handler = new ArrayList<>();
		player = new Player(this, Assets.PLAYER, new Vector2D(640, 640),7);
	}

	@Override
	public void draw(Graphics g) {
		player.draw(g);
		for(int i = 0; i < handler.size(); i++) {
			Shot shot = (Shot) handler.get(i);
			shot.draw(g);
		}
	}

	@Override
	public void update() {
		player.update();
		for(int i = 0; i < handler.size(); i++) {
			Shot shot = (Shot) handler.get(i);
			shot.update();
		}
	}

	public ArrayList<Shot> getHandler() {
		return handler;
	}
	
}
