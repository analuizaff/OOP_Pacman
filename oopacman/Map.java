package oopacman;

import javafx.scene.canvas.GraphicsContext;
import static java.lang.Math.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Alexylva
 */
public class Map implements EntityObject{
    private StaticEntity[][] map;
    private static final int gridWidth = 20, gridHeight = 15; //4:3
    //Real width, height
    private int width = (int) floor(OOPacman.ga.getWidth()) ,
            height = (int) floor(OOPacman.ga.getHeight());
    
    public Map(String pathToMapFile) {
        map = new StaticEntity[gridWidth][gridHeight];
        int[][] mapInt = this.readMap( pathToMapFile );
        this.criarMapa( mapInt );

    }

    private void criarMapa( int[][] mapaInt ){
        for (int i = 0; i < gridWidth ; i++){
            for ( int j = 0; j < gridHeight; j++ ){
                if (mapaInt[i][j] == 1){
                    this.map[i][j] = new Wall(i,j);
                }else if (mapaInt[i][j] == 0){
                    this.map[i][j] = new Path(i,j);
                }else if (mapaInt[i][j] == 2){
                    this.map[i][j] = new Pacman(i,j);
                }else if (mapaInt[i][j] == 3){
                    this.map[i][j] = new Ghost(i,j,new Color(1.00, 0, 0, 1.0) );
                }
                else if (mapaInt[i][j] == 4){
                    this.map[i][j] = new Ghost(i,j,new Color(0, 1.00, 0, 1.0) );
                }
                else if (mapaInt[i][j] == 5){
                    this.map[i][j] = new Ghost(i,j,new Color(0, 0, 1.00, 1.0) );
            }
        }
    }

    private int[][] readMap(String pathToFile){
        try {

            FileReader leitor = new FileReader(gridWidth, gridHeight);
            int matrizMapaInt[][] = leitor.readFile(pathToFile);
            return matrizMapaInt;

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int[] snapToGrid(int x, int y) {
        return new int[] {(int) gridWidth*((int) floor(x/gridWidth)), gridHeight*((int) floor(y/gridHeight))};   
    };
    
    
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
