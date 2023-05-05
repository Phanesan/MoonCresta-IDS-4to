package main.java.panel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.Border;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MenuPanel extends JPanel  {
	private Clip clip;
	public MenuPanel() {
		setSize(1280,720);
		setBackground(Color.GRAY);
		
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1280, 720);
		add(panel);
		
		
		BordeRedondo border = new BordeRedondo(15);
		
		JButton Empezar = new JButton("Empezar");
		Empezar.setForeground(new Color(255, 255, 255));
		
		Empezar.setBackground(new Color(0, 0, 0));
		Empezar.setFont(new Font("Wide Latin", Font.PLAIN, 25));
		Empezar.setBorder(border);
		Empezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(null);
		Empezar.setBounds(490, 301, 284, 55);
		panel.add(Empezar);
		
		JButton Salir = new JButton("Salir");
		Salir.setForeground(new Color(255, 255, 255));
		Salir.setBorder(border);
		Salir.setBackground(new Color(0, 0, 0));
		Salir.setFont(new Font("Wide Latin", Font.PLAIN, 25));
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Salir.setBounds(535, 405, 201, 55);
		panel.add(Salir);
		
		JLabel Titulo = new JLabel("New label");
		Titulo.setForeground(new Color(64, 128, 128));
		Titulo.setBackground(new Color(0, 128, 0));
		Titulo.setBounds(430, 11, 400, 255);
		Titulo.setIcon(new ImageIcon("Titulo.png"));
		panel.add(Titulo);
		
		JButton Musica = new JButton("M");
		Musica.setFont(new Font("Tahoma", Font.BOLD, 26));
		Musica.setForeground(new Color(255, 255, 255));
		Musica.setBorder(border);
		Musica.setBackground(new Color(0, 0, 0));
		Musica.setBounds(11, 516, 60, 60);
		Musica.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				 if (e.getSource() == Musica) {
					 
			            try {
			                // Carga el archivo de audio
			                File audioFile = new File("Tema.wav");
			                clip = AudioSystem.getClip();
			                clip.open(AudioSystem.getAudioInputStream(audioFile));

			                // Reproduce el audio
			                clip.start();

			            } catch (Exception ex) {
			                System.err.println("Error al reproducir audio: " + ex.getMessage());
			            }
			        }
			}
		});
		panel.add(Musica);
		
		
		JLabel Fondo = new JLabel("");
		Fondo.setForeground(new Color(64, 128, 128));
		Fondo.setBackground(new Color(0, 128, 0));
		Fondo.setBounds(0, 0, 1280, 720);
		Fondo.setIcon(new ImageIcon("Fondo.gif"));
		panel.add(Fondo);
		
		
		
		panel.repaint();
		panel.revalidate();
		
		
		
	}
	
	
	class BordeRedondo implements Border {

	    private int radio;  

	    BordeRedondo(int radius) {
	        this.radio = radius;
	    }  

	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radio+1, this.radio+1, this.radio+2, this.radio);
	    }  

	    public boolean isBorderOpaque() {
	        return true;
	    }

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        g.drawRoundRect(x, y, width-1, height-1, radio, radio);
			
		}  
	}
	

}
