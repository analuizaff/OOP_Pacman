/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopacman;

import static oopacman.Actor.Status.*;

/**
 *
 * @author Alexylva
 */
abstract class Actor extends Entity {

    
    private int currentX, currentY, targetX, targetY, scale, speed;
    private Key buffer, facing;
    private Status status;
    enum Status {IDLE, MOVING, SPECIAL};

    public Actor(int x, int y, String tipo) {
        super(x, y, tipo);
    }
    
    public void mover(Key dir, int step) {
        switch (dir) {
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
    
    
    public void direcionar(Key dir, int step) {
        return;/*
        if (getStatus() == MOVING) { setBuffer(dir); return; } 
        switch (currDir) {
            case UP:
                setTargetY(getCurrentY() - step);
                break;
            case DOWN:
                setTargetY(getCurrentY() + step);
                break;
            case RIGHT:
                setTargetX(getCurrentX() + step);
                break;
            case LEFT:
                setTargetX(getCurrentX() - step);
                break;
        }
        setStatus(MOVING);*/
    }
    
    /*
    public void mover() {
        if (getStatus() == MOVING) {
            if (getX() != getTargetX() || getY() != getTargetY()) {
                mover(currDir, 1);
            } else {
                setStatus(IDLE);
            }
        } else if (getStatus() == IDLE) {
            mover();
        }
    }
    */
    
    public void mover() {
        //mover(currDir, 1);
        return;
    }
    
    
    public boolean intercepta(Entity entity) {
        return false; //TODO
    }
    
    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }
    
    public Key getBuffer() {
        return buffer;
    }

    public void setBuffer(Key buffer) {
        this.buffer = buffer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getTargetX() {
        return targetX;
    }

    public void setTargetX(int targetX) {
        this.targetX = targetX;
    }

    public int getTargetY() {
        return targetY;
    }

    public void setTargetY(int targetY) {
        this.targetY = targetY;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
