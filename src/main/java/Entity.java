package main.java;

public class Entity{
	
	private boolean alive;
	private Location location;
	
	public Entity(Location location) {
		this.alive = true;
		this.location = location;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public boolean kill() {
		return false;
		
	}
	
	public Location getLocation() {
		return location;
	}
	
}
