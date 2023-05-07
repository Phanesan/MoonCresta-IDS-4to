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
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import main.java.utils.ImageUtil;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MenuPanel extends JPanel  {
	private Clip clip;
	
	public MenuPanel() {
		
		setSize(1280,720);
		setBackground(new Color(0, 0, 0));
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
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 
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
		Salir.setBounds(535, 405, 201, 55);
		panel.add(Salir);
		
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		
		JLabel Titulo = new JLabel("New label");
		Titulo.setForeground(new Color(64, 128, 128));
		Titulo.setBackground(new Color(0, 128, 0));
		Titulo.setBounds(430, 11, 400, 255);
		
		Titulo.setIcon(new ImageIcon(ImageUtil.resizeImage(400, 228, ImageUtil.getStream("main/resources/Titulo.png"))));
		panel.add(Titulo);
		
		JButton Musica = new JButton("On");
		Musica.setFont(new Font("Tahoma", Font.BOLD, 15));
		Musica.setForeground(new Color(255, 255, 255));
		Musica.setBorder(border);
		Musica.setBackground(new Color(0, 0, 0));
		Musica.setBounds(11, 516, 60, 60);
		File audioFile = new File("Tema.wav");
		
		
		
		
		try {
            // Crear un objeto Clip y cargar el audio
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(audioFile));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
		
		Musica.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == Musica) {
		            if (clip.isActive()) {
		                clip.stop();
		              
		                Musica.setText("off");
		                
		            } else {
		                clip.loop(Clip.LOOP_CONTINUOUSLY);
		                Musica.setText("On");
		               
		            }
		        }
			        
			}
		});
		panel.add(Musica);
		
		
		JLabel Fondo = new JLabel("");
		Fondo.setFont(new Font("Wide Latin", Font.PLAIN, 25));
		Fondo.setForeground(new Color(255, 255, 255));
		Fondo.setBackground(new Color(255, 255, 255));
		Fondo.setBounds(0, 0, 1280, 720);
		Fondo.setIcon(new ImageIcon("Fondo.gif"));
		panel.add(Fondo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(11, 492, 46, 14);
		panel.add(lblNewLabel);
		
		
		
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
