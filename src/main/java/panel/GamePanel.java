package main.java.panel;

import java.awt.Color;

import javax.swing.JPanel;

import main.java.Location;
import main.java.Player;
import main.java.WindowFrame;
import main.java.thread.GameThread;
import main.java.thread.ThreadGameHandler;
import main.java.utils.FrameUtil;
import main.java.utils.ImageUtil;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

public class GamePanel extends JPanel {

	private WindowFrame instanceMain;
	private Player player;
	private Image airship;
	private ThreadGameHandler threadGameHandler;
	private Thread gameLoop;
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
