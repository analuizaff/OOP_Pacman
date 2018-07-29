/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopacman;

import static oopacman.Actor.Status.*;
import static oopacman.Key.*;
import static oopacman.OOPacman.map;

/**
 *
 * @author Alexylva
 */
abstract class Actor extends Entity {

    enum Status {IDLE, MOVING, BUFFERED, SPECIAL};
    
    private int currentX, currentY, targetX, targetY, scale, speed;
    private Key buffer, direction = UP;
    private Status status;
    

    public Actor(int x, int y, String tipo) {
        super(x, y, tipo);
    }
    
    public abstract void mover(Key dir, int step);
    
    
    public void direcionar(Key dir, int step) {
        if (getStatus() == MOVING || getStatus()== IDLE) { setBuffer(dir); return; }
        setStatus(MOVING);
    }
    
    public void mover() {
        if(null != getStatus())switch (getStatus()) {
            case IDLE:
                return;
            case MOVING:
                mover(getDirection(), 1);
                break;
            case BUFFERED:
                if (map.dirIsFree(getGridX(), getGridY(), buffer)) {
                    setDirection(buffer);
                };
                break;
            default:
                break;
        }
        
        return;
    }
    
    
    public boolean intercepta(Entity entity) {
        return false; //TODO
    }
    
    public int getGridX() {
        return map.xyToGrid(getX(),getY())[0];
    }
    
    public int getGridY() {
        return map.xyToGrid(getX(),getY())[1];
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
        if(getDirection() != buffer) {
            this.buffer = buffer;
            setStatus(BUFFERED);
        }
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
    
    public Key getDirection() {
        return direction;
    }

    public void setDirection(Key direction) {
        this.direction = direction;
        setBuffer(null);
    }

}
