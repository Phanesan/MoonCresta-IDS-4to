package main.java;

public class Entity{
	
	private boolean alive = false;
	private Location location;
	
	public Entity(Location location) {
		this.location = getLocation();
		this.alive = isAlive();
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
