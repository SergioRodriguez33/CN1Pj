package com.csus.csc133;

import java.util.Vector;

public class GameModel {
    private int width;
    private int height;
    private int gameTime;
    private Vector<GameObject> gameObjects;

    public GameModel() {
        this.width = 1000;
        this.height = 800;
        this.gameTime = 0;
        this.gameObjects = new Vector<>();
        init();
    }

    public void init() {
        // Initialize all game objects
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
    }

    public void nextFrame() {
        gameTime += 1;
        for (GameObject obj : gameObjects) {
            if (obj instanceof Imoveable) {
                ((Imoveable) obj).move();
            }
        }
    }

    public void handleCollision(int command) {
    	//test collision
        System.out.println("you collided by pressing 1");
    }

    public StudentPlayer getPlayer() {
        for (GameObject obj : gameObjects) {
            if (obj instanceof StudentPlayer) {
                return (StudentPlayer) obj;
            }
        }
        return null; // or handle this case as needed
    }

    public void outputGameStatus() {
        // Method to output game status
    }
}
