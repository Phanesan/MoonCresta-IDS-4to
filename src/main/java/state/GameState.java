package main.java.state;

import java.awt.Graphics;

import main.java.Drawable;
import main.java.Updateable;
import main.java.Vector2D;
import main.java.graphics.Assets;
import main.java.graphics.objects.Player;

public class GameState implements Updateable,Drawable{
	
	private Player player;
	
	public GameState() {
		player = new Player(Assets.PLAYER, new Vector2D(640, 640),7);
	}

	@Override
	public void draw(Graphics g) {
		player.draw(g);
	}

	@Override
	public void update() {
		player.update();
	}
	
}
