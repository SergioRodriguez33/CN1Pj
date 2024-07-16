package com.csus.csc133;

import java.util.Random;

public class StudentHappy extends Student{

	public StudentHappy(double x, double y) {
		super(x, y);
		
	}

	@Override
	public void handleCollide(Student s) {
		// TODO Auto-generated method stub
		
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

}
