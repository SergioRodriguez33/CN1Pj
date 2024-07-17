package com.csus.csc133;

public class Restroom extends Facility {

    public Restroom(double x, double y) {
        super(x, y);
    }

    @Override
    public void handleCollide(Student s) {
        s.clearWaterIntake();
        System.out.println("Student's water intake cleared by Restroom collision.");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ", pos (" + roundToOneDecimal(getX()) + ", " + roundToOneDecimal(getY()) + ")";
    }
}
