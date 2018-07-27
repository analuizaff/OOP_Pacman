/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopacman;

/**
 *
 * @author Alexylva
 */
abstract class Actor extends Entity {

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

    public boolean intercepta(Entity entity) {
        return false; //TODO
    }

}
