package com.csus.csc133;

public abstract class Facility extends GameObject {
    public Facility(double x, double y) {
        super(x, y);
    }
    
    protected double roundToOneDecimal(double value) {
        return Math.round(value * 10.0) / 10.0;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ", pos (" + roundToOneDecimal(getX()) + ", " + roundToOneDecimal(getY()) + ")";
    }
}