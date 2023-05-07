package main.java.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import main.java.Entity;
import main.java.Location;
import main.java.Player;
import main.java.panel.GamePanel;

public class ThreadGameHandler {
	
	private GamePanel instance;
	private volatile HashMap<Thread,Boolean> handler;
	
	public ThreadGameHandler(GamePanel instance) {
		this.instance = instance;
		handler = new HashMap<>();
	}
	
	public Thread startThread(Runnable runnable) {
		Thread thread = new Thread(runnable);
		handler.put(thread,true);
		thread.start();
		return thread;
	}
	
	public void stopThread(Thread thread) {
		handler.replace(thread,false);
	}

	public HashMap<Thread,Boolean> getHandler() {
		return handler;
	}

	public GamePanel getInstance() {
		return instance;
	}
	
}
