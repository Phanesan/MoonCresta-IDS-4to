package main.java.graphics.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.IOException;

import main.java.Drawable;
import main.java.Updateable;
import main.java.Vector2D;
import main.java.graphics.Assets;
import main.java.graphics.GameObject;
import main.java.state.GameState;

public class HUD implements Updateable,Drawable{
	
	private String scoreText;
	
	public HUD() {
		scoreText = "PUNTAJE: " + Player.score;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString(scoreText, 50, 50);
	}

	@Override
	public void update() {
		scoreText = "PUNTAJE: " + Player.score;
	}

}
