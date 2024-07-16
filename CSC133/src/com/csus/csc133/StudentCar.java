package com.csus.csc133;
import java.util.Random;


public class StudentCar extends Student {
    public StudentCar(double x, double y) {
        super(x, y);
        this.speed = DEFAULT_SPEED * 5;
        this.sweatingRate = 0;
    }
    Random random = new Random();
    double randomValue = random.nextDouble();
    
    @Override
    public void move() {
        if (timeRemain > 0) {
            timeRemain--;
        } else {
            // Only move horizontally
            this.x += Math.cos(Math.toRadians(90.0 - head)) * speed;
            if (this.head != 90 && this.head != 270) {
                this.head = (randomValue < 0.5) ? 90 : 270;
            }
            hydration -= sweatingRate;

            if (this.x < 0) { this.x = 0; this.head = 270; }
            if (this.x > 1000) { this.x = 1000; this.head = 90; }
        }
    }

    @Override
    public void handleCollide(Student s) {
        // Handle collision logic
    }
}
