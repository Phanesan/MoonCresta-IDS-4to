package main.java.utils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;

public class Sound {
	
	private Clip clip;
	private AudioInputStream audioInputStream;
	
	public Sound(Clip clip, AudioInputStream audioInputStream) {
		this.clip = clip;
		this.audioInputStream = audioInputStream;
	}

	public Clip getClip() {
		return clip;
	}

	public AudioInputStream getAudioInputStream() {
		return audioInputStream;
	}
	
}
