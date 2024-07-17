package com.csus.csc133;

public class StudentFriendly extends Student {

	public StudentFriendly(double x, double y) {
		super(x, y);
		this.talkativeLevel = DEFAULT_TALKATIVELEVEL *0.5;
	}

	@Override
	public void handleCollide(Student s) {
		System.out.println("You collided with the friendly student!");
		
	}
	
	@Override
    public String toString() {
        return super.toString(); // Uses the toString implementation from the Student class
    }

}
