package com.csus.csc133;

public class LectureHall extends Facility {
    private String name;
    private Lecture currentLecture;

    public LectureHall(double x, double y, String name) {
        super(x, y);
        this.name = name;
        this.currentLecture = null;
    }
    
    public void startLecture(Lecture lecture) {
        this.currentLecture = lecture;
    }

    public void endLecture() {
        this.currentLecture = null;
    }

    public boolean isLectureInProgress() {
        return currentLecture != null && currentLecture.getTimeRemaining() > 0;
    }

    public void decreaseLectureTime() {
        if (currentLecture != null) {
            currentLecture.decreaseTime(1);
        }
    }

    public double getLectureTime() {
        return currentLecture != null ? currentLecture.getTimeRemaining() : 0;
    }

    @Override
    public void handleCollide(Student s) {
        if (s instanceof StudentPlayer && currentLecture != null) {
            currentLecture.endLecture();
            System.out.println("Lecture ended by StudentPlayer collision.");
        }
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + name + ", pos (" + roundToOneDecimal(getX()) + ", " + roundToOneDecimal(getY()) + "), Current Lecture: " + (currentLecture == null ? "null" : currentLecture.getTimeRemaining());
    }

    
}