/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopacman;

import javafx.scene.canvas.GraphicsContext;
import static java.lang.Math.*;

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
    
    public int[] snapToGrid(int x, int y) {
        return new int[] {(int) gridWidth*floor(x/gridWidth), (int) gridHeight*floor(y/gridHeight))};
    }
    
    public int[] xyToGrid(int x, int y) {
        return new int[] {(int) floor(x*gridWidth/width), (int) floor(y*gridHeight/height)};
    }
    
    public int[] gridToXY(int gridX, int gridY) {
        return new int[] {(int) floor(width*gridX/gridWidth), (int) floor(height*gridY/gridHeight)};
    }
    
    @Override
    public void render(GraphicsContext gc, double time) {
        for(int i = 0, j = 0; i < 20 && j < 15; i++, j++) {
            gc.fillRect(map[i][j].getX(), map[i][j].getY(), map[i][j].getSize(), map[i][j].getSize()); //Substituir pelo render de cada Entity
        }
    }

    @Override
    public void update(GraphicsContext gc, double time) {}
    
    
}
