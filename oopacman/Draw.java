/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopacman;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import static oopacman.OOPacman.*;

/**
 *
 * @author Alexylva
 */
public class Draw extends AnimationTimer {

    private long frameCount = 0;
    private LongValue lastNanoTime;

    public Draw(LongValue lastNanoTime) {
        this.lastNanoTime = lastNanoTime;
    }

    @Override
    public void handle(long currentNanoTime) {
        double elapsedTime = (currentNanoTime - lastNanoTime.getValue()) / 1000000000.0;
        lastNanoTime.setValue(currentNanoTime);
        gc.setFill(new Color(0,0,0,1));
        gc.fill();
        gc.fillRect(0, 0, width, height);
        
        updateEntities(gameObjects, elapsedTime);
        renderEntities(gameObjects, elapsedTime);
        
        frameCount++;
    }
}
