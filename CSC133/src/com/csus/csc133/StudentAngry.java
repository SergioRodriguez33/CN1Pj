package com.csus.csc133;

public class StudentAngry extends Student {

	public StudentAngry(double x, double y) {
		super(x, y);
		this.talkativeLevel = DEFAULT_TALKATIVELEVEL *2;
	}

	@Override
	public void handleCollide(Student s) {
		// TODO Auto-generated method stub
		
	}

}
