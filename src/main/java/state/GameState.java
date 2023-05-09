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
	private ArrayList <MovingObject> handler;
	
	public GameState() {
		handler = new ArrayList<>();
		player = new Player(this, Assets.PLAYER, new Vector2D(640, 640),7);
		handler.add(player);
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
	}

	public ArrayList<MovingObject> getHandler() {
		return handler;
	}
	
}
