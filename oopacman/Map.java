/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopacman;

import javafx.scene.canvas.GraphicsContext;
import static java.lang.Math.floor;

/**
 *
 * @author Alexylva
 */
public class Map implements EntityObject{
    private StaticEntity[][] map;
    private int gridWidth = 20, gridHeight = 15; //4:3
    //Real width, height
    private int width = (int) floor(OOPacman.ga.getWidth()) ,
            height = (int) floor(OOPacman.ga.getHeight());
    
    public Map(Boolean[][] grid) {
        map = new Wall[20][15];
    }
    
    public int[] xyToGrid(int x, int y) {
        return new int[] {(int) Math.floor(x/gridWidth), (int) Math.floor(y/gridHeight)};
    }
    
    public int[] gridToXY(int gridX, int gridY) {
        return new int[] {(int) Math.floor(20/gridWidth), (int) Math.floor(y/gridHeight)};
    }
    
    @Override
    public void render(GraphicsContext gc, double time) {
        for(int i = 0, j = 0; i < 20 && j < 15; i++, j++) {
            gc.fillRect(map[i][j].getX(), map[i][j].getY(), map[i][j].getSize(), map[i][j].getSize());
        }
    }

    @Override
    public void update(GraphicsContext gc, double time) {}
    
    
}
