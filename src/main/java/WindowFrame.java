package main.java;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.java.graphics.Assets;
import main.java.state.GameState;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.BoxLayout;

public class WindowFrame extends JFrame implements Runnable{
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	private static final String windowName = "MoonCresta";
	private static volatile boolean running = false;
	private static final Canvas canvas = new Canvas();
	private static int APS = 0;
	private static int FPS = 0;
	
	private Thread thread;
	private Key key;
	private BufferStrategy bs;
	private Graphics g;
	private GameState gameState;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowFrame frame = new WindowFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public WindowFrame() {
		canvas.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH,HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH,HEIGHT));
		
		//setTitle(windowName);
		setIconImage(Assets.LOGO);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		add(canvas, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
		
		start();
	}

	@Override
	public void run() {
		canvas.requestFocus();
		
		final int NPS = 1000000000;
		final byte APS_TARGET = 60;
		final double NPF = NPS / APS_TARGET;
		
		long startFrame = System.nanoTime();
		long frameCont = System.nanoTime();
		
		double timeElapsed;
		double delta = 0;
		while(running) { // EL HILO EMPEZARA A REPETIRSE A LA VELOCIDAD DE LA PC
			final long startLoop = System.nanoTime();
			timeElapsed = startLoop - startFrame;
			startFrame = startLoop;
			delta+=timeElapsed/NPF;
			
			if(delta >= 1) { // AQUI SE EJECUTARA CADA QUE PASE UN FRAME POR SEGUNDO
				update();				
				delta--;
			}			
			draw();
			
			if(System.nanoTime() - frameCont > NPS) {
				setTitle(windowName + " | APS:" + APS + " FPS: " + FPS);
				APS = 0;
				FPS = 0;
				
				frameCont = System.nanoTime();
			}
		}
	}
	
	public void update() {
		APS++;
		
		// METODOS UPDATE //
		key.update();
		gameState.update();
		
		// CONDICIONES
		
	}
	
	public void draw() {
		FPS++;
		bs = canvas.getBufferStrategy();
		
		if(bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		// Fondo
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.drawImage(Assets.BACKGROUND_GAME,0,0,null);
		
		// METODOS DRAW //
		gameState.draw(g);
		//////////////////
		
		g.dispose();
		bs.show();
	}
	
	public synchronized void start() {
		running = true;
		
		// INICIA CLASES
		thread = new Thread(this);
		key = new Key();
		gameState = new GameState();
		
		// LISTENERS
		canvas.addKeyListener(key);
		
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
