package main.java.panel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class GraphicGamePanel extends JComponent{
	
	private GamePanel instance;
	
	public GraphicGamePanel(GamePanel instance) {
		setPreferredSize(new Dimension(720,720));
		this.instance = instance;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(instance.getAirship(), instance.getPlayer().getLocation().x, instance.getPlayer().getLocation().y, null);
	}
}
