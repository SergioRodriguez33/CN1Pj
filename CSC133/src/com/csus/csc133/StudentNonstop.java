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
        //need to edit this to where timeRemain can't change
    }
}

