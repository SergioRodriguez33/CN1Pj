package com.csus.csc133;

public class StudentAngry extends Student {

	public StudentAngry(double x, double y) {
		super(x, y);
		this.talkativeLevel = DEFAULT_TALKATIVELEVEL *2;
	}

	@Override
	public void handleCollide(Student s) {
		System.out.println("You collided with the angry student!");
		
	}
	
	@Override
    public String toString() {
        return super.toString() + "I'm angry!"; // Uses the toString implementation from the Student class
    }

}
