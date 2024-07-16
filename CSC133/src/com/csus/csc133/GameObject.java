package com.csus.csc133;

public abstract class GameObject {
	protected double x;
	protected double y;
	
	public GameObject(double x, double y) {
		this.x =x;
		this.y =y;
	}
	
	public abstract void handleCollide(Student s);
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x =x;
	}
	
	public void setY(double y) {
		this.y =y;
	}
}
