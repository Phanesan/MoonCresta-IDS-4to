package main.java.thread;

import java.awt.event.KeyEvent;

import main.java.Moveable.Direction;
import main.java.Player;
import main.java.panel.GamePanel;

public class GameThread	implements Runnable {
	
	private ThreadGameHandler instance;
	private volatile boolean running;
	private Object lock;
	
	public GameThread(ThreadGameHandler instance) {
		this.instance = instance;
		lock = new Object();
		running = true;
	}
	
	@Override
	public void run() {
		synchronized (lock) {
			while(running) {
				if(!instance.getHandler().get(Thread.currentThread())) {
					running = false;
				}
				
				instance.getInstance().getInstanceMain().requestFocus();
				
				// Movimiento del jugador
				
				Player p = instance.getInstance().getPlayer();
				int key = 0;
				if(instance.getInstance().getInstanceMain().getLastKey() != null) {
					key = instance.getInstance().getInstanceMain().getLastKey().getKeyCode();
				}
				
				switch(key) {
					case KeyEvent.VK_A:
						p.move(Direction.LEFT);
						break;
					case KeyEvent.VK_D:
						p.move(Direction.RIGHT);
						break;
				}
				instance.getInstance().getInstanceMain().setLastKey(null);
				
				instance.getInstance().getInstanceMain().getContentPanel().revalidate();
				instance.getInstance().getInstanceMain().getContentPanel().repaint();
			}
		}
	}
	
}
