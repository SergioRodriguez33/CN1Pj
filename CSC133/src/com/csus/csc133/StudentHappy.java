package com.csus.csc133;

import java.util.Random;

public class StudentHappy extends Student{

	public StudentHappy(double x, double y) {
		super(x, y);
		
	}

	@Override
	public void handleCollide(Student s) {
		System.out.println("You collided with the happy student!");
		
	}
	
	@Override
	public void move() {
		if (new Random ().nextDouble() < 0.1) {
			this.speed *= 10;
			super.move();
			this.speed = DEFAULT_SPEED;
		}
		
		else {
			super.move();
		}
	}
	
	@Override
    public String toString() {
        return super.toString() + "I'm happy!"; // Uses the toString implementation from the Student class
    }

}
