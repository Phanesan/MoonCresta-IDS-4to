package main.java.graphics.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import main.java.Drawable;
import main.java.Mouse;
import main.java.Updateable;
import main.java.Vector2D;

public class ButtonGame implements Updateable,Drawable{
	
	private BufferedImage mouseOutImg;
	private BufferedImage mouseInImg;
	private boolean mouseIn;
	private Rectangle boundingBox;
	private String text;
	private ClickListener listener;
	
	public ButtonGame(BufferedImage mouseOutImg,
					BufferedImage mouseInImg,
					String text,
					int x,
					int y) { 
		this.mouseInImg = mouseInImg;
		this.mouseOutImg = mouseOutImg;
		boundingBox = new Rectangle(x,y,mouseInImg.getWidth(),mouseInImg.getHeight());
		this.text = text;
	}

	@Override
	public void draw(Graphics g) {
		if(mouseIn) {
			g.drawImage(mouseInImg,boundingBox.x,boundingBox.y,null);
		} else {
			g.drawImage(mouseOutImg,boundingBox.x,boundingBox.y,null);
		}
		
		if(text != null) {
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			
			int x = boundingBox.x + boundingBox.width/2;
			int y = boundingBox.y + boundingBox.height;
			FontMetrics fm = g.getFontMetrics();
			x = x - fm.stringWidth(text)/2;
			y = y-16;
			
			g.drawString(text, x, y);
		}
	}

	@Override
	public void update() {
		if(boundingBox.contains(Mouse.x,Mouse.y)) {
			mouseIn = true;
		} else {
			mouseIn = false;
		}
		
		if(mouseIn && Mouse.M1) {
			listener.actionPerformed();
		}
	}
	
	public void addClickListener(ClickListener listener) {
		this.listener = listener;
	}
	
}
