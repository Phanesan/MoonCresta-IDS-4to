package main.java;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

public class Mouse extends MouseAdapter {
	
	public static int x,y;
	public static boolean M1;
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			M1 = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			M1 = false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}
	
}
