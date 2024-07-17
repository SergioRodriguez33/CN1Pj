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
		System.out.println("Your speed is " + this.speed);
	}
	
	public void turnLeft () {
		System.out.println("You are turning left, head was: "+ this.head);
		this.head -= 5;
		if (this.head <0) {
			this.head += 360;
		}
		System.out.println("Your head is now: " + this.head);
	}
	
	public void turnRight () {
		System.out.println("You are turning right, head was: "+ this.head);
		this.head += 5;
		if (this.head >= 360) {
            this.head -= 360;
        }
		System.out.println("Your head is now: " + this.head);
	}
 
	@Override
	public void handleCollide(Student s) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
    public String toString() {
        return super.toString(); // Uses the toString implementation from the Student class
    }

}
