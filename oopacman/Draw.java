/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopacman;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import static oopacman.OOPacman.*;

/**
 *
 * @author Alexylva
 */
public class Draw extends AnimationTimer {

    public static long frameCount = 0;
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
        
        updateEntities(uiObject, elapsedTime);
        renderEntities(uiObject, elapsedTime);
        
        gc.save();
        gc.translate(ga.getX(), ga.getY()); //Seta novo ponto 0,0 no canto da gameArea
        renderEntities(mapObject, elapsedTime);
        updateEntities(entityObject, elapsedTime);
        renderEntities(entityObject, elapsedTime);
        gc.restore();
        frameCount++;
    }
    
    public void updateEntities(ArrayList<GameObject> gameobjects, double time) {
        for (GameObject gob : gameobjects) {
            if (gob != null) {
                gob.update(gc, time);
            }
        }
    }

    /**
     * Realiza a logica de renderização de cada entidade
     *
     * @param gameobjects Array de entidades
     * @param time Tempo atual
     */
    public void renderEntities(ArrayList<GameObject> gameobjects, double time) {
        for (GameObject gob : gameobjects) {
            if (gob != null) {
                gob.render(gc, time);
            }
        }
    }
}
