package com.csus.csc133;

public class StudentRunning extends Student {
    public StudentRunning(double x, double y) {
        super(x, y);
        this.sweatingRate = super.sweatingRate * 2;
    }

    @Override
    public void handleCollide(Student s) {
    	System.out.println("You collided with the running student!");
    }
    
    @Override
    public String toString() {
        return super.toString() + "Running"; // Uses the toString implementation from the Student class
    }
}
