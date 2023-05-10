package main.java.state;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import main.java.Drawable;
import main.java.Sound;
import main.java.Updateable;
import main.java.Vector2D;
import main.java.WindowFrame;
import main.java.graphics.Assets;
import main.java.graphics.MovingObject;
import main.java.graphics.objects.Enemy;
import main.java.graphics.objects.Player;
import main.java.graphics.objects.Shot;
import main.java.graphics.objects.Wall;

public class GameState implements Updateable,Drawable{
	
	private Player player;
	private ArrayList <MovingObject> handler;
	private ArrayList<Wall> wallHandler;
	private Sound background;
	
	public GameState() {
		handler = new ArrayList<>();
		wallHandler = new ArrayList<>();
		wallHandler.add(new Wall(this,new Dimension(5,WindowFrame.HEIGHT),new Vector2D(0,0)));
		wallHandler.add(new Wall(this,new Dimension(5,WindowFrame.HEIGHT),new Vector2D(WindowFrame.WIDTH-5,0)));
		player = new Player(this, Assets.PLAYER, new Vector2D(640, 640),6);
		handler.add(player);
		
		background = new Sound(Assets.BACKGROUND_OST);
		background.loop(726000,7292000);
	}

	@Override
	public void draw(Graphics g) {
		for(int i = 0; i < handler.size(); i++) {
			handler.get(i).draw(g);
			//handler.get(i).drawHitBox(g);
		}
		
//		for(int i = 0; i < wallHandler.size(); i++) {
//			wallHandler.get(i).drawHitBox(g);
//		}
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

	public ArrayList<Wall> getWallHandler() {
		return wallHandler;
	}
	
}
