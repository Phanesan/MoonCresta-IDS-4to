package main.java.state;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import main.java.Sound;
import main.java.WindowFrame;
import main.java.graphics.Assets;
import main.java.graphics.UI.ButtonGame;
import main.java.graphics.UI.ClickListener;

public class MenuState extends State{
	
	private ButtonGame start;
	private ArrayList<ButtonGame> listButton;
	
	public MenuState() {
		listButton = new ArrayList<>();
		
		ButtonGame startButton = new ButtonGame(Assets.BUTTON_OUT, Assets.BUTTON_IN, "INICIAR", WindowFrame.WIDTH/2-Assets.BUTTON_IN.getWidth()/2 , 350);
		ButtonGame exitButton = new ButtonGame(Assets.BUTTON_OUT, Assets.BUTTON_IN, "SALIR", WindowFrame.WIDTH/2-Assets.BUTTON_IN.getWidth()/2 , 440);
		ButtonGame Sounds = new ButtonGame(Assets.SOUND_ON, Assets.SOUND_OFF, "", WindowFrame.WIDTH/9-Assets.BUTTON_IN.getWidth()/2 , 600);
		
		Sound Tema = new Sound(Assets.MENU);
		Tema.start();
		
		startButton.addClickListener(new ClickListener() {

			@Override
			public void actionPerformed() {
				// TODO Auto-generated method stub
				
			}});
		
		
		exitButton.addClickListener(new ClickListener() {

			@Override
			public void actionPerformed() {
				// TODO Auto-generated method stub
				System.exit(0);
			}});
		
		Sounds.addClickListener(new ClickListener() {

			@Override
			public void actionPerformed() {
				// TODO Auto-generated method stub
				
				Tema.setVolume(-230);
				
			}});
		
		
		listButton.add(startButton);
		listButton.add(exitButton);
		listButton.add(Sounds);
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(Assets.MENU_BACKGROUND,0,0,null);
		
		for(ButtonGame button : listButton) {
			button.draw(g);
		}
		
		g.drawImage(Assets.LOGO,435,50,null);
	}

	@Override
	public void update() {
		for(ButtonGame button : listButton) {
			button.update();
		}
	}

}
