package com.csus.csc133;

public class StudentSleeping extends Student{

	public StudentSleeping(double x, double y) {
		super(x, y);
		this.sweatingRate =0;
	}

	@Override
	public void handleCollide(Student s) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void move() {
		//doesn't move or sweat
	}

}
