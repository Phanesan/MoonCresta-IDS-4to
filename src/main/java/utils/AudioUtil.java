package main.java.utils;

import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public abstract class AudioUtil {
	
	public static Sound getSound(AudioInputStream audioInput) {
		
		Clip clip = null;
		try {
			clip = AudioSystem.getClip();
			clip.open(audioInput);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Sound(clip,audioInput);
	}
	
}
