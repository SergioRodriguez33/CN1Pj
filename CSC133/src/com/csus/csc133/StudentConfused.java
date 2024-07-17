package com.csus.csc133;

import java.util.Random;

public class StudentConfused extends Student {
    public StudentConfused(double x, double y) {
        super(x, y);
    }

    @Override
    public void move() {
    	//constantly decrement timer
        if (timeRemain > 0) {
            timeRemain--;
        } 
        //add a random value to head
        else {
            this.head += new Random().nextInt(360);
            super.move();
        }
    }

    @Override
    public void handleCollide(Student s) {
    	System.out.println("You collided with the confused student!");
    }
    
    @Override
    public String toString() {
        return super.toString(); // Uses the toString implementation from the Student class
    }
}

