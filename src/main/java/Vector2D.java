package main.java;

public class Vector2D {
	
	public double x,y;
	
	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2D() {
		this.x = 0;
		this.y = 0;
	}
	
	public void addVector(Vector2D vector) {
		x = vector.x + x;
		y = vector.y + y;
	}
	
	public void minusVector(Vector2D vector) {
		x = vector.x - x;
		y = vector.y - y;
	}
	
	public void addX(double x) {
		this.x += x; 
	}
	
	public void addY(double y) {
		this.y += y; 
	}
	
	public void minusX(double x) {
		this.x -= x; 
	}
	
	public void minusY(double y) {
		this.y -= y; 
	}
}
