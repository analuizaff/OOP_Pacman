package oopacman;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author Alexylva
 */
public class OOPacman extends Application { // Stage -> Scene -> Nodes

    static Scene pacmanScene;
    static GraphicsContext gc;
    static int width = 800;
    static int height = 600;

    static GameArea ga; //Area de jogo

    static ArrayList<GameObject> gameObjects; //Entidades que possuem metodos render() e update();
    static ArrayList<String> input;

    @Override
    public void start(Stage stage) {
        /* Esse bloco é executado apenas uma vez */

        stage.setTitle("OOP Pacman"); //Titulo

        Group root = new Group(); //Grupo raiz, onde são adicionados todos os elementos
        Canvas canvas = new Canvas(width, height); //Nossa tela
        root.getChildren().add(canvas); //Adiciona a tela ao grupo

        gc = canvas.getGraphicsContext2D(); //Obtem a instancia do GraphicsContext2D
        pacmanScene = new Scene(root); //Cena principal
        stage.setScene(pacmanScene); //Determina a cena exibida no stage

        input = new ArrayList<>(); //Array que conterá as teclas pressionadas

        //Comandos que determinam qual classes serão chamadas no evento de pressionamento e soltura de teclas 
        pacmanScene.setOnKeyPressed(new keyPressed());
        pacmanScene.setOnKeyReleased(new keyReleased());

        gameObjects = new ArrayList<>();
        setupObjects(); //Adiciona os objetos a Array gameObjects;

        LongValue lastNanoTime = new LongValue(System.nanoTime()); //Obtem o tempo atual, classe LongValue apenas para evitar erro de contexto estatico
        new Draw(lastNanoTime).start(); //Loop da logica do jogo, essa função é chamada a cada frame

        stage.show(); //Exibe a GUI do jogo
    }

    private void setupObjects() {
        gameObjects.add(new GameArea(width * 0.533, height * 0.947, width * 0.1, height * 0.03)); //3:4, 10%, 3%
        gameObjects.add(new Pacman(width / 2, height / 2)); //Teste
    }

    /**
     * Realiza a logica de atualização de cada entidade
     *
     * @param gameobjects Array de entidades
     * @param time Tempo atual
     */
    public static void updateEntities(ArrayList<GameObject> gameobjects, double time) {
        for (GameObject gob : gameobjects) {
            if (gob != null) {
                gob.update(gc, time);
            }
        }
    }

    /**
     * Realiza a logica de renderização de cada entidade
     *
     * @param gameobjects Array de entidades
     * @param time Tempo atual
     */
    public static void renderEntities(ArrayList<GameObject> gameobjects, double time) {
        for (GameObject gob : gameobjects) {
            if (gob != null) {
                gob.render(gc, time);
            }
        }
    }

    public static boolean isPressed(Key key) {
        return input.contains(key.toString());
    }

    private static class keyPressed implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent e) {
            String code = e.getCode().toString();

            if (!input.contains(code)) { //Evita duplicatas
                input.add(code);
                System.out.println(input);
            }
        }
    }

    private static class keyReleased implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent e) {
            String code = e.getCode().toString();
            input.remove(code);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args); //Inicia a aplicação
    }

}
