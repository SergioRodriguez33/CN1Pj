package com.csus.csc133;

public class StudentSleeping extends Student{

	public StudentSleeping(double x, double y) {
		super(x, y);
		this.sweatingRate =0;
	}

	@Override
	public void handleCollide(Student s) {
		System.out.println("You collided with the sleeping student!");
		
	}
	
	@Override
	public void move() {
		//doesn't move or sweat
	}
	
	@Override
    public String toString() {
        return super.toString() + "zzzZZZ!"; // Uses the toString implementation from the Student class
    }

}
