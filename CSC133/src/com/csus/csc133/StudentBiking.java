package com.csus.csc133;

public class StudentBiking extends Student {
    public StudentBiking(double x, double y) {
        super(x, y);
        this.speed = DEFAULT_SPEED * 3;
        this.sweatingRate = 3.0 * 2;
    }

    @Override
    public void handleCollide(Student s) {
    	System.out.println("You collided with the biking student!");
    }
    
    @Override
    public String toString() {
        return super.toString() + "Biking"; // Uses the toString implementation from the Student class
    }
}

