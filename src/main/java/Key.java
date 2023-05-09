package main.java;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener,Updateable {
	
	private static final int CODE_MAX_KEY = 256;
	private boolean[] keys = new boolean[CODE_MAX_KEY];
	
	public static boolean LEFT = false;
	public static boolean RIGHT = false;
	public static boolean SPACE = false;
		
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void update() {
		LEFT = keys[KeyEvent.VK_A];
		RIGHT = keys[KeyEvent.VK_D];
		SPACE = keys[KeyEvent.VK_SPACE];
	}

}
