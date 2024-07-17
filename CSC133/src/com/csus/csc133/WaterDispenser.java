package com.csus.csc133;

public class WaterDispenser extends Facility {

    public WaterDispenser(double x, double y) {
        super(x, y);
    }

    @Override
    public void handleCollide(Student s) {
        s.drinkWater();
        System.out.println("Student drank water from WaterDispenser.");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ", pos (" + roundToOneDecimal(getX()) + ", " + roundToOneDecimal(getY()) + ")";
    }
}
