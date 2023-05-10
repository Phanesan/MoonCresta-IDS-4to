package main.java;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent.Type;
import javax.sound.sampled.LineUnavailableException;

import main.java.graphics.Loader;

public class Sound implements Updateable{
	
	private Clip sound;
	private boolean runningLoop;
	private int frameStartLoop,frameEndLoop;
	
	public Sound(String path) {
		sound = Loader.soundLoader(path);
	}
	
	public void start() {
		sound.stop();
		sound.flush();
		sound.setMicrosecondPosition(0);
		sound.start();
	}
	
	public void loop(int frameStartLoop, int frameEndLoop) {
		this.frameStartLoop = frameStartLoop;
		this.frameEndLoop = frameEndLoop;
		sound.stop();
		sound.flush();
		sound.setMicrosecondPosition(0);
		sound.start();
		runningLoop = true;
	}
	
	public void stopLoop() {
		runningLoop = false;
		sound.stop();
		sound.flush();
		sound.setMicrosecondPosition(0);
	}
	
	public void setSound(float volume) {
		
	}

	@Override
	public void update() {
		if(runningLoop) {
			if((sound.getFramePosition() >= frameEndLoop)) {
				sound.setFramePosition(frameStartLoop);
				sound.setLoopPoints(frameStartLoop, frameEndLoop);
			}
		}
	}
	
}
