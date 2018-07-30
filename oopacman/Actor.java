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

    enum Status {
        IDLE, MOVING, BUFFERED, SPECIAL
    };

    private int currentX, currentY, targetX, targetY, scale, speed;
    private Key buffer, direction = UP;
    private Status status;

    public Actor(int x, int y, String tipo) {
        super(x, y, tipo);
    }

    public void mover(Key dir, int step) {
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

    public void direcionar(Key dir, int step) {
        if (getStatus() == MOVING || getStatus() == IDLE) {
            setBuffer(dir);
            return;
        }
        setStatus(MOVING);
    }

    public void mover() {
        if (null != getStatus()) {
            switch (getStatus()) {
                case IDLE:

                    return;
                case MOVING:
                    Wall wall = map.dirIsFree(getGridX(), getGridY(), getDirection());
                    if (wall != null) {
                        switch (getDirection()) {
                            case UP:
                                if (getY() <= (wall.getY() + wall.getSize() + 2)) {
                                    return;
                                }
                                break;
                            case DOWN:
                                if (getY() >= (wall.getY() - wall.getSize() + 2)) {
                                    return;
                                }
                                break;
                            case LEFT:
                                if (getX() <= (wall.getX() + wall.getSize() + 2)) {
                                    return;
                                }
                                break;
                            case RIGHT:
                                if (getX() >= (wall.getX() - wall.getSize() + 2)) {
                                    return;
                                }
                                break;
                            default:
                                throw new AssertionError(getDirection().name());

                        }
                    }
                    mover(getDirection(), 1);
                    break;
                case BUFFERED:
                    setDirection(buffer);
                    break;
                default:
                    break;
            }
        }
        //} else {
        //}
    }

    public boolean intercepta(Entity entity) {
        return false; //TODO
    }

    public int getGridX() {
        return map.xyToGrid(getX(), getY())[0];
    }

    public int getGridY() {
        return map.xyToGrid(getX(), getY())[1];
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
        if (getDirection() != buffer) {
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
