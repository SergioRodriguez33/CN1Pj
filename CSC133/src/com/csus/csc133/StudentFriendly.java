package com.csus.csc133;

public class StudentFriendly extends Student {

	public StudentFriendly(double x, double y) {
		super(x, y);
		this.talkativeLevel = DEFAULT_TALKATIVELEVEL *0.5;
	}

	@Override
	public void handleCollide(Student s) {
		// TODO Auto-generated method stub
		
	}
	
	

}
