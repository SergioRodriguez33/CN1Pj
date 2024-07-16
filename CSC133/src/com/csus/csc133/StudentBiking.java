package com.csus.csc133;

public class StudentBiking extends Student {
    public StudentBiking(double x, double y) {
        super(x, y);
        this.speed = DEFAULT_SPEED * 3;
        this.sweatingRate = 3.0 * 2;
    }

    @Override
    public void handleCollide(Student s) {
        // Handle collision logic
    }
}

