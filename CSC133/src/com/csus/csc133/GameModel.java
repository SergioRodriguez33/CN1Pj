package com.csus.csc133;

import java.util.Random;
import java.util.Vector;

public class GameModel {
    private int width;
    private int height;
    private int gameTime;
    private Vector<GameObject> gameObjects;
    private Random random;
    private StudentPlayer player;

    public GameModel() {
        this.width = 1000;
        this.height = 800;
        this.gameTime = 0;
        this.gameObjects = new Vector<>();
        this.random = new Random();
    }

    public void init() {
        // Initialize game objects
        gameObjects.add(new StudentAngry(100, 100));
        gameObjects.add(new StudentBiking(150, 200));
        gameObjects.add(new StudentCar(200, 200));
        gameObjects.add(new StudentConfused(200, 400));
        gameObjects.add(new StudentFriendly(300, 320));
        gameObjects.add(new StudentHappy(500, 100));
        gameObjects.add(new StudentNonstop(100, 700));
        gameObjects.add(new StudentPlayer(400, 500));
        gameObjects.add(new StudentRunning(100, 600));
        gameObjects.add(new StudentSleeping(800, 350));

        gameObjects.add(new LectureHall(100, 100, "RVR1013"));
        gameObjects.add(new Restroom(200, 200));
        gameObjects.add(new WaterDispenser(300, 300));
        
        // Set the player object for easy access
        player = getPlayer();
    }

    public void nextFrame() {
        gameTime += 1;

        // Step 1: Check and potentially start a new lecture
        LectureHall lectureHall = null;
        for (GameObject obj : gameObjects) {
            if (obj instanceof LectureHall) {
                lectureHall = (LectureHall) obj;
                if (lectureHall.isLectureInProgress()) {
                    break;
                }
            }
        }

        if (lectureHall == null || !lectureHall.isLectureInProgress()) {
            if (random.nextDouble() < 0.1) { // 10% probability
                startNewLecture();
            }
        } else {
            lectureHall.decreaseLectureTime();
            if (lectureHall.getLectureTime() <= 0) {
                endLecture(lectureHall);
            }
        }

        // Step 2: Move all game objects
        moveGameObjects();

        // Step 3: Check game over conditions
        if (checkGameOver()) {
            System.out.println("Gameover. Time: " + gameTime);
        }
    }

    private void startNewLecture() {
        LectureHall lectureHall = (LectureHall) chooseRandomLectureHall();
        if (lectureHall != null) {
            lectureHall.startLecture(new Lecture(10)); // Start a new lecture with a duration of 10
            System.out.println("New lecture started in " + lectureHall);
        }
    }

    private GameObject chooseRandomLectureHall() {
        Vector<GameObject> lectureHalls = new Vector<>();
        for (GameObject obj : gameObjects) {
            if (obj instanceof LectureHall) {
                lectureHalls.add(obj);
            }
        }
        if (lectureHalls.size() > 0) {
            return lectureHalls.get(random.nextInt(lectureHalls.size()));
        }
        return null;
    }

    private void endLecture(LectureHall lectureHall) {
        // End the lecture
        lectureHall.endLecture();

        // Check if the player reached the hall on time
        if (!lectureHall.isLectureInProgress()) {
            player.increaseAbsenceTime();
        }
    }

    private void moveGameObjects() {
        for (GameObject obj : gameObjects) {
            if (obj instanceof Imoveable) {
                ((Imoveable) obj).move();
            }
        }
    }

    private boolean checkGameOver() {
        // Implement game over conditions here
        // Example conditions:
        // - StudentPlayer absent in too many lectures
        // - Too many waters intake or hydration reaches zero
        // Return true if game over, false otherwise
        if (player.getAbsenceTime() > 3) {
        	System.out.println("Too many absences");
            return true;
        }
        if (player.getHydration() <= 0) {
        	System.out.println("Dehydrated");
            return true;
        }
        if (player.getWaterIntake() > 10) {
        	System.out.println("waterintake too high");
            return true;
        }
        return false;
    }
    
/* if (player.getAbsenceTime() > 3) {
            System.out.println("Game over, absent 3 lectures");
            return true;
        } else if (player.getWaterIntake() > 100) {
            System.out.println("Game over, too high water intake");
            return true;
        } else if (player.getHydration() <= 0) {
            System.out.println("Game over, dehydrated");
            return true;
        }
        return false;*/
    
    public StudentPlayer getPlayer() {
        for (GameObject obj : gameObjects) {
            if (obj instanceof StudentPlayer) {
                return (StudentPlayer) obj;
            }
        }
        return null; // or handle this case as needed
    }
    
    public void outputGameStatus() {
        System.out.println("Time: " + gameTime);
        for (GameObject obj : gameObjects) {
            System.out.println(obj);
        }
    }

    public void handleCollision(int command) {
        // Handle collision based on command
        switch (command) {
            case 1:
                for (GameObject obj : gameObjects) {
                    if (obj instanceof LectureHall) {
                        LectureHall lectureHall = (LectureHall) obj;
                        lectureHall.handleCollide(player);
                        endLecture(lectureHall);
                    }
                }
                break;
            case 2:
                for (GameObject obj : gameObjects) {
                    if (obj instanceof Restroom) {
                        ((Restroom) obj).handleCollide(player);
                    }
                }
                break;
            case 3:
                for (GameObject obj : gameObjects) {
                    if (obj instanceof WaterDispenser) {
                        ((WaterDispenser) obj).handleCollide(player);
                    }
                }
                break;
            case 4:
                Student randomStudent = chooseRandomStudent();
                if (randomStudent != null) {
                    randomStudent.handleCollide(player);
                }
                break;
        }
    }

    private Student chooseRandomStudent() {
        Vector<Student> nonPlayerStudents = new Vector<>();
        for (GameObject obj : gameObjects) {
            if (obj instanceof Student && !(obj instanceof StudentPlayer)) {
                nonPlayerStudents.add((Student) obj);
            }
        }
        if (!nonPlayerStudents.isEmpty()) {
            return nonPlayerStudents.get(random.nextInt(nonPlayerStudents.size()));
        }
        return null;
    }

}

