package com.csus.csc133;

public class StudentRunning extends Student {
    public StudentRunning(double x, double y) {
        super(x, y);
        this.sweatingRate = super.sweatingRate * 2;
    }

    @Override
    public void handleCollide(Student s) {
        // Handle collision logic
    }
}
