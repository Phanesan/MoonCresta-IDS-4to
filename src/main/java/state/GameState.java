package main.java.state;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import main.java.Drawable;
import main.java.Sound;
import main.java.Spawner;
import main.java.Updateable;
import main.java.Vector2D;
import main.java.WindowFrame;
import main.java.graphics.Assets;
import main.java.graphics.MovingObject;
import main.java.graphics.UI.ButtonGame;
import main.java.graphics.UI.ClickListener;
import main.java.graphics.objects.Enemy;
import main.java.graphics.objects.HUD;
import main.java.graphics.objects.Player;
import main.java.graphics.objects.Shot;
import main.java.graphics.objects.Wall;

public class GameState extends State{
	
	public Player player;
	private ArrayList <MovingObject> handler;
	private ArrayList<Wall> wallHandler;
	private HUD hud;
	private Sound background;
	private Spawner spawner;
	public boolean isDeath;
	private ButtonGame exitButton;
	
	public GameState() {
		handler = new ArrayList<>();
		wallHandler = new ArrayList<>();
		spawner = new Spawner(this);
		hud = new HUD();
		isDeath = false;
		
		exitButton = new ButtonGame(Assets.BUTTON_OUT, Assets.BUTTON_IN, "SALIR", WindowFrame.WIDTH/2-Assets.BUTTON_IN.getWidth()/2 , 550);
		exitButton.addClickListener(new ClickListener() {
			@Override
			public void actionPerformed() {
				State.changeState(new MenuState());
			}
		});
		
		wallHandler.add(new Wall(this,new Dimension(5,WindowFrame.HEIGHT),new Vector2D(0,0)));
		wallHandler.add(new Wall(this,new Dimension(5,WindowFrame.HEIGHT),new Vector2D(WindowFrame.WIDTH-5,0)));
		
		player = new Player(this, Assets.PLAYER, new Vector2D(640, 640),6,1);
		handler.add(player);
		
		background = new Sound(Assets.BACKGROUND_OST);
		background.loop(726000,7292000);
		background.setVolume(-7);
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(Assets.BACKGROUND_GAME,0,0,null);
		for(int i = 0; i < handler.size(); i++) {
			handler.get(i).draw(g);
		}
		spawner.draw(g);
		hud.draw(g);
		if(isDeath) {
			g.drawImage(Assets.BLACKSCREEN,0,0,null);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 70));
			g.drawString("GAMEOVER",425, 360);
			exitButton.draw(g);
			background.stopLoop();
		}
	}

	@Override
	public void update() {
		for(int i = 0; i < handler.size(); i++) {
			handler.get(i).update();
		}
		background.update();
		spawner.update();
		hud.update();
		if(isDeath) {			
			exitButton.update();
		}
	}

	public ArrayList<MovingObject> getHandler() {
		return handler;
	}

	public ArrayList<Wall> getWallHandler() {
		return wallHandler;
	}
	
}
