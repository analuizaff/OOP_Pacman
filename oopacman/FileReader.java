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

            for (int j = 0; j < colunas; j++) {
                matrizFinal[i][j] = Character.getNumericValue(matrizChar[j]);
            }
        }

        return matrizFinal;
    }


}