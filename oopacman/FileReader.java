package oopacman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    private int linhas;
    private int colunas;


    public FileReader(int linhas, int colunas){
        this.linhas = linhas;
        this.colunas = colunas;
    }

    public int[][] readFile(String url) throws IOException {
        Path path = Paths.get(url);

        int[][] matrizFinal = new int[linhas][colunas];

        List<String> linhas = Files.readAllLines(path);
        String[] matrizLinha = linhas.toArray(new String[0]); //new String[0] serve pra ele retornar a matriz no tipo certo

        for (int i = 0; i < this.linhas; i++) {
            char[] matrizChar = matrizLinha[i].toCharArray();

            for (int j = 0; j < this.colunas; j++) {
                matrizFinal[i][j] = Character.getNumericValue(matrizChar[j]);
            }
        }

        return matrizFinal;
    }

    /*
    public static void main( String[] args ){
        try {
            int a[][];
            FileReader leitor = new FileReader(20, 15);
            a = leitor.readFile("oopacman/MapaTeste.txt");
            for (int i = 0; i < a.length ; i++){
                    for (int j = 0; j < a[i].length; j++){
                            System.out.print(a[i][j]);
                    }
                    System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    */

}
