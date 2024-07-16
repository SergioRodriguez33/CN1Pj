package com.csus.csc133;

public class StudentPlayer extends Student{

	public StudentPlayer(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public void startMoving () {
		this.speed = DEFAULT_SPEED;
		System.out.println("Your speed is " + this.speed);
	}
	
	public void stopMoving () {
		this.speed = 0;
	}
	
	public void turnLeft () {
		this.head -= 5;
		if (this.head <0) {
			this.head += 360;
		}
	}
	
	public void turnRight () {
		this.head += 5;
		if (this.head >= 360) {
            this.head -= 360;
        }
	}
 
	@Override
	public void handleCollide(Student s) {
		// TODO Auto-generated method stub
		
	}

}
