package main.java;

import main.java.exception.OutOfRangeCanonException;

public class Player extends Entity implements Moveable{
	
	private int numCanon;
	private int score;
	private int speed;
	
	public Player(Location location) {
		super(location);
		numCanon = 1;
		score = 0;
		speed = 10;
	}

	@Override
	public void move(Direction direction) {
		switch(direction) {
			case LEFT:
				getLocation().x-=speed;
				break;
			case RIGHT:
				getLocation().x+=speed;
				break;
		}
	}
	
	public void upgradeCanon() throws OutOfRangeCanonException {
		int temp = this.numCanon + 1;
		if(temp <= 3) {
			this.numCanon += 1;
		} else 
			throw new OutOfRangeCanonException();
	}
	
	public void downgradeCanon() throws OutOfRangeCanonException{
		int temp = this.numCanon - 1;
		if(temp > 0) {
			this.numCanon -= 1;
		} else
			throw new OutOfRangeCanonException();
			
	}

	public void addScore(int score) {
		this.score += score;
	}
	
	public int getNumCanon() {
		return numCanon;
	}


	public int getScore() {
		return score;
	}

}
