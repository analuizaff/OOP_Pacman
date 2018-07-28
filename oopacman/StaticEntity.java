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
public abstract class StaticEntity implements EntityObject {
    private int x, y, size;
    
    public StaticEntity(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    public int getSize() {
        return size;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
