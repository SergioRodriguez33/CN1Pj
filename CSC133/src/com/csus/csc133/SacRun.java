package com.csus.csc133;

import com.codename1.ui.*;
import com.codename1.ui.events.*;

public class SacRun extends Form {

    private GameModel gm;

    public SacRun() {
        gm = new GameModel();
        A1();
        gm.init();
    }

    // UI provided for A1 only, remove it in A2
    private void A1() {
        Label myLabel = new Label("Enter a Command:");
        TextField myTextField = new TextField();
        this.add(myLabel).add(myTextField);
        this.show();
        myTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String sCommand = myTextField.getText().toString();
                myTextField.clear();
                if (sCommand.isEmpty()) return;
                handleInput(sCommand.charAt(0));
            }
        });
    }

    private void handleInput(char key) {
        switch (key) {
            case 'w': startPlayerMoving(); break;
            case 's': stopPlayerMoving(); break;
            case 'a': turnPlayerLeft(); break;
            case 'd': turnPlayerRight(); break;
            case '1': handleCollision(1); break;
            case '2': handleCollision(2); break;
            case '3': handleCollision(3); break;
            case '4': handleCollision(4); break;
            case 'f': nextFrame(); break;
            case 'm': outputGameStatus(); break;
            case 'i': outputStudentInfo(); break;
            default: System.out.println("Invalid command"); break;
        }
    }

    private void startPlayerMoving() {
        gm.getPlayer().startMoving();
    }

    private void stopPlayerMoving() {
        gm.getPlayer().stopMoving();
    }

    private void turnPlayerLeft() {
        gm.getPlayer().turnLeft();
    }

    private void turnPlayerRight() {
        gm.getPlayer().turnRight();
    }

    private void handleCollision(int command) {
        gm.handleCollision(command);
    }

    private void nextFrame() {
        gm.nextFrame();
    }

    private void outputGameStatus() {
        gm.outputGameStatus();
    }

    private void outputStudentInfo() {
        System.out.println("Sergio Rodriguez");
    }
}
