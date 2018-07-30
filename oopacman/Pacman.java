/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopacman;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import static oopacman.Actor.Status.IDLE;
import static oopacman.Key.*;
import static oopacman.OOPacman.map;

/**
 *
 * @author Alexylva
 */
public class Pacman extends Actor {

    public Pacman(int x, int y) {
        super(x, y, "Pacman");
        setSize((int) Math.floor(OOPacman.ga.getWidth() * 0.05)); //20:15
        setSpeed(10);
    }

    @Override
    public void mover(Key dir, int step) {
        if (!map.dirIsFree(getGridX(), getGridY(), dir)) {
            setStatus(IDLE);
            return;
        }
        switch (getDirection()) {
            case UP:
                setY(getY() - step);
                break;
            case DOWN:
                setY(getY() + step);
                break;
            case RIGHT:
                setX(getX() + step);
                break;
            case LEFT:
                setX(getX() - step);
                break;
        }
    }

    @Override
    public void render(GraphicsContext gc, double time) {
        gc.setFill(new Color(1.00, 1.00, 0.50, 1.0));
        gc.setStroke(new Color(0, 0, 0, 1));
        gc.fillOval(getX(), getY(), getSize(), getSize());
        gc.strokeOval(getX(), getY(), getSize(), getSize());
    }
    String lastStatus = "";
    @Override
    public void update(GraphicsContext gc, double time) {
        String now = String.format("%s (%d,%d)\n", getStatus(), getGridX(), getGridY());
        if (!lastStatus.equals(now)) System.out.print(now);
        lastStatus = now;
        if (isPressed(UP)) {
            direcionar(UP, getSpeed());
        } else if (isPressed(DOWN)) {
            direcionar(DOWN, getSpeed());
        } else if (isPressed(LEFT)) {
            direcionar(LEFT, getSpeed());
        } else if (isPressed(RIGHT)) {
            direcionar(RIGHT, getSpeed());
        }
        mover();
    }

}
