package main.java.state;

import java.awt.Graphics;
import java.util.ArrayList;

import main.java.WindowFrame;
import main.java.graphics.Assets;
import main.java.graphics.UI.ButtonGame;

public class MenuState extends State{
	
	private ButtonGame start;
	private ArrayList<ButtonGame> listButton;
	
	public MenuState() {
		listButton = new ArrayList<>();
		
		ButtonGame startButton = new ButtonGame(Assets.BUTTON_OUT, Assets.BUTTON_IN, "INICIAR", WindowFrame.WIDTH/2-Assets.BUTTON_IN.getWidth()/2 , 400);
		ButtonGame exitButton = new ButtonGame(Assets.BUTTON_OUT, Assets.BUTTON_IN, "SALIR", WindowFrame.WIDTH/2-Assets.BUTTON_IN.getWidth()/2 , 480);
		
		listButton.add(startButton);
		listButton.add(exitButton);
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(Assets.MENU_BACKGROUND,0,0,null);
		
		for(ButtonGame button : listButton) {
			button.draw(g);
		}
	}

	@Override
	public void update() {
		for(ButtonGame button : listButton) {
			button.update();
		}
	}

}
