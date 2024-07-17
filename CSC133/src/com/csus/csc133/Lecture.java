package com.csus.csc133;

public class Lecture {
    private double timeRemaining;

    public Lecture(int i) {
        this.timeRemaining = 10;
    }

    

	public double getTimeRemaining() {
        return timeRemaining;
    }

    public void decreaseTime(double amount) {
        timeRemaining -= amount;
        if (timeRemaining < 0) {
            timeRemaining = 0;
        }
    }

    public void endLecture() {
        timeRemaining = 0;
    }
}
