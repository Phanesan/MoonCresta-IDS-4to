package main.java;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

import main.java.panel.GamePanel;
import main.java.panel.MenuPanel;
import main.java.utils.FrameUtil;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class WindowFrame extends JFrame {

	private JPanel contentPane;
	private SoundHandler soundHandler;
	private KeyEvent lastKey;

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
		soundHandler = new SoundHandler(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280,720);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		FrameUtil.changePanel(this, new MenuPanel(this));
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				lastKey = e;
			}
		});
	}
	
	public KeyEvent getLastKey() {
		return lastKey;
	}

	public void setLastKey(KeyEvent lastKey) {
		this.lastKey = lastKey;
	}

	public SoundHandler getSoundHandler() {
		return soundHandler;
	}
	
	public JPanel getContentPanel() {
		return contentPane;
	}
	
	
}
