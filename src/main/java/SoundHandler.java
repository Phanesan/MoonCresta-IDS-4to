package main.java;

import java.io.IOException;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import main.java.utils.AudioUtil;
import main.java.utils.Sound;

public class SoundHandler {
	
	private WindowFrame frameInstance;
	private volatile HashMap<Clip,AudioInputStream> handler;
	
	public SoundHandler(WindowFrame frameInstance) {
		this.frameInstance = frameInstance;
		handler = new HashMap<>();
	}
	
	public Sound startSound(AudioInputStream audioInputStream,float volumen) {
		Sound sound = AudioUtil.getSound(audioInputStream);
		FloatControl control = getVolumeControl(sound.getClip());
		control.setValue(volumen);
		sound.getClip().start();
		handler.put(sound.getClip(),audioInputStream);
		return sound;
	}
	
	public void removeSound(Clip clip) {
		clip.stop();
		try {
			handler.get(clip).close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		handler.remove(clip);
	}
	
	public FloatControl getVolumeControl(Clip clip) {
		return (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	}
	
}
