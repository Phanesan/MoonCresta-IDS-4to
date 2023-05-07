package main.java.panel;

import java.awt.Color;

import javax.swing.JPanel;

import main.java.Location;
import main.java.Player;
import main.java.WindowFrame;
import main.java.thread.GameThread;
import main.java.thread.ThreadGameHandler;
import main.java.utils.AudioUtil;
import main.java.utils.FrameUtil;
import main.java.utils.ImageUtil;
import main.java.utils.Sound;

import java.awt.BorderLayout;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineEvent.Type;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;

public class GamePanel extends JPanel {

	private WindowFrame instanceMain;
	private Player player;
	private Image airship;
	private ThreadGameHandler threadGameHandler;
	private Thread gameLoop;
	private Sound backgroundTrack;
	private volatile boolean runningLoop;
	private int airshipSize;
	
	public GamePanel(WindowFrame instanceMain) {
		airshipSize = 50;
		
		airship = ImageUtil.resizeImage(airshipSize, airshipSize, FrameUtil.getStream("main/resources/airship.png"));
		
		threadGameHandler = new ThreadGameHandler(this);
		this.instanceMain = instanceMain;
		
		player = new Player(new Location(410, 600));
		setSize(1280,720);
		setBackground(Color.BLUE);
		setLayout(new BorderLayout(0, 0));
		
		JPanel InfoPanel = new JPanel();
		InfoPanel.setBackground(Color.GRAY);
		InfoPanel.setBorder(new EmptyBorder(0, 100, 0, 100));
		add(InfoPanel, BorderLayout.EAST);
		InfoPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel top = new JPanel();
		top.setBorder(new EmptyBorder(40, 0, 0, 0));
		top.setOpaque(false);
		InfoPanel.add(top, BorderLayout.NORTH);
		top.setLayout(new BorderLayout(0, 0));
		
		JLabel scoreLabel = new JLabel("Score: 0");
		scoreLabel.setFont(new Font("Century Gothic", Font.BOLD, 40));
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setBorder(new EmptyBorder(40, 0, 40, 0));
		top.add(scoreLabel, BorderLayout.CENTER);
		
		JPanel mid = new JPanel();
		mid.setOpaque(false);
		InfoPanel.add(mid, BorderLayout.CENTER);
		mid.setLayout(new BorderLayout(0, 0));
		
		JLabel healthLabel = new JLabel("Vidas: 3");
		healthLabel.setFont(new Font("Century Gothic", Font.BOLD, 40));
		mid.add(healthLabel, BorderLayout.CENTER);
		
		JPanel Game = new JPanel();
		Game.setBackground(Color.BLACK);
		add(Game, BorderLayout.CENTER);
		Game.setLayout(new BorderLayout(0, 0));
		
		GraphicGamePanel graphicGamePanel = new GraphicGamePanel(this);
		Game.add(graphicGamePanel, BorderLayout.CENTER);
		
		gameLoop = threadGameHandler.startThread(new GameThread(threadGameHandler));
		
		try {
			backgroundTrack = instanceMain.getSoundHandler().startSound(AudioSystem.getAudioInputStream(FrameUtil.getStream("main/resources/sounds/background/track1.wav")), 0.5f);
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Clip backgroundClip = backgroundTrack.getClip();
		runningLoop = true;
		/*Thread backgroundLoopThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (backgroundClip) {
					while(runningLoop) {
						if(backgroundClip.getFramePosition() > 7333752) {
							backgroundClip.setFramePosition(728845);
							
						}
						if(!backgroundClip.isActive()) {
							runningLoop = false;
							System.out.println("stop soundtrack");
						}
					}
				}
			}
		});*/
		Thread backgroundLoopThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (backgroundClip) {
					while(runningLoop) {
						System.out.println(backgroundClip.getFramePosition());
						if(backgroundClip.getMicrosecondPosition() > 17550000) {
							backgroundClip.setLoopPoints(720045, 7283752);
							backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
							runningLoop = false;
						}
					}
				}
			}
		});
		backgroundLoopThread.start();
	}

	public Player getPlayer() {
		return player;
	}

	public Image getAirship() {
		return airship;
	}

	public WindowFrame getInstanceMain() {
		return instanceMain;
	}

}
