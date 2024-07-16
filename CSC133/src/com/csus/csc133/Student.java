package com.csus.csc133;

import java.util.Random;

public abstract class Student extends GameObject implements Imoveable {
    public static final double DEFAULT_SPEED = 200.0;
    public static final double DEFAULT_TALKATIVELEVEL = 2.0;

    protected double head;
    protected double speed;
    protected double talkativeLevel;
    protected double timeRemain;
    protected double hydration;
    protected double waterIntake;
    protected double sweatingRate;
    protected int absenceTime;

    public Student(double x, double y) {
        super(x, y);
        this.head = new Random().nextInt(360);
        this.speed = DEFAULT_SPEED;
        this.talkativeLevel = DEFAULT_TALKATIVELEVEL;
        this.timeRemain = 0;
        this.hydration = 200.0;
        this.waterIntake = 0;
        this.sweatingRate = 3.0;
        this.absenceTime = 0;
    }

    public void move() {
        if (timeRemain > 0) {
            timeRemain--;
        } else {
            this.x += Math.cos(Math.toRadians(90.0 - head)) * speed;
            this.y += Math.sin(Math.toRadians(90.0 - head)) * speed;
            hydration -= sweatingRate;

            if (this.x < 0) { this.x = 0; this.head += 180; }
            if (this.y < 0) { this.y = 0; this.head += 180; }
            if (this.x > 1000) { this.x = 1000; this.head += 180; }
            if (this.y > 800) { this.y = 800; this.head += 180; }
        }
    }

    // Implement abstract method from GameObject
    @Override
    public abstract void handleCollide(Student s);
}
