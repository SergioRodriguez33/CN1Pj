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
        StudentPlayer player = gm.getPlayer();
        if (player == null) {
            System.out.println("Player not found");
            return;
        }
        
        switch (key) {
            case 'w': player.startMoving(); break;
            case 's': player.stopMoving(); break;
            case 'a': player.turnLeft(); break;
            case 'd': player.turnRight(); break;
            case '1': gm.handleCollision(1); break;
            case '2': gm.handleCollision(2); break;
            case '3': gm.handleCollision(3); break;
            case '4': gm.handleCollision(4); break;
            case 'f': gm.nextFrame(); break;
            case 'm': gm.outputGameStatus(); break;
            case 'i': System.out.println("Your Name"); break;
            default: System.out.println("Invalid command"); break;
        }
    }
}
