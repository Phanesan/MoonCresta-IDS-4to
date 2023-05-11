package main.java.graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Loader {
	
	public static BufferedImage imageLoader(String path) {
		try {
			return ImageIO.read(Loader.class.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Clip soundLoader(String path) {
		Clip clip;
		
		try {
			InputStream is = Loader.class.getResourceAsStream(path);
			AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(is));
			clip = AudioSystem.getClip();
			clip.open(ais);
			return clip;
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
