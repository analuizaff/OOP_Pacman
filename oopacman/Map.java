package oopacman;

import javafx.scene.canvas.GraphicsContext;
import static java.lang.Math.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Alexylva
 */
public class Map implements EntityObject {
    private StaticEntity[][] map;
    private static final int gridLines = 20, gridColumns = 15; //4:3
    //Real width, height
    private int width = (int) floor(OOPacman.ga.getWidth()) ,
            height = (int) floor(OOPacman.ga.getHeight());
    
    public Map(String pathToMapFile) {
        map = new StaticEntity[gridLines][gridColumns];
        int[][] mapInt = this.readMap( pathToMapFile );
        /*int[][] mapInt = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                          {1,0,1,1,1,0,1,1,1,1,1,1,1,1,1},
                          {1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
                          {1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
                          {1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
                          {1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
                          {1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
                          {1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
                          {1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
                          {1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
                          {1,1,1,1,1,1,0,1,1,0,0,0,0,0,1},
                          {1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
                          {1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
                          {1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
                          {1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
                          {1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
                          {1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
                          {1,1,1,1,0,0,1,1,1,1,1,1,1,0,1},
                          {1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
                          {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        };*/
        this.criarMapa( mapInt );

    }

    private void criarMapa( int[][] mapaInt ){
        int[] grid;
        for (int i = 0; i < gridLines; i++){
            for ( int j = 0; j < gridColumns; j++ ){
                grid = gridToXY(j,i);
                if (mapaInt[i][j] == 1){
                    this.map[i][j] = new Wall(grid[0],grid[1]);
                } else if (mapaInt[i][j] == 0){
                    this.map[i][j] = new Path(grid[0],grid[1]);
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
    }

    private int[][] readMap(String pathToFile){
        try {

            FileReader leitor = new FileReader(gridLines, gridColumns);
            int matrizMapaInt[][] = leitor.readFile(pathToFile);
            return matrizMapaInt;

        }catch(Exception e){
            System.out.println("Bunda");
        }
        return null;
    }

    public int[] snapToGrid(int x, int y) {
        return new int[] {(int) gridColumns*((int) floor(x/gridColumns)), gridLines*((int) floor(y/gridLines))};   
    };
    
    
    public int[] xyToGrid(int x, int y) {
        return new int[] {(int) floor(x*gridLines/width), (int) floor(y*gridColumns/height)};
    }
    
    public int[] gridToXY(int gridX, int gridY) {
        return new int[] {(int) floor(width*gridX/gridColumns), (int) floor(height*gridY/gridLines)};
    }
    
    @Override
    public void render(GraphicsContext gc, double time) {
        for(int i = 0; i < gridLines; i++) {
            for(int j = 0; j < gridColumns; j++) {
                if (map[i][j] != null)
                    map[i][j].render(gc, time);
            }
        }
    }

    @Override
    public void update(GraphicsContext gc, double time) {}
    
    
}
