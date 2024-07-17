package com.csus.csc133;

public class StudentNonstop extends Student {
    public StudentNonstop(double x, double y) {
        super(x, y);
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void handleCollide(Student s) {
        this.timeRemain = 1;
        System.out.println("You collided with the nonstop talking student!");
        //need to edit this to where timeRemain can't change
    }
    
    @Override
    public String toString() {
        return super.toString(); // Uses the toString implementation from the Student class
    }
}

