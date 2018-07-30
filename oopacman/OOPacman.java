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
    
    //Entidades que possuem metodos render() e update();
    static ArrayList<GameObject> uiObject = new ArrayList<>(); //Desenhados no geral
    static ArrayList<GameObject> entityObject = new ArrayList<>(); //Desenhados em GameArea
    static ArrayList<GameObject> mapObject = new ArrayList<>();
    
    static GameArea ga = new GameArea(width * 0.533, height * 0.947, width * 0.1, height * 0.03); //Area de jogo (sorry for the magic numbers) 3:4 aspect, x:10%, y:3%
    static Map map = new Map("maps/map1.txt");
    static UserInterface ui = new UserInterface(width * 0.65,height*0.03);
    
    
    
    static ArrayList<String> input; //Lista de teclas pressionadas
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args); //Inicia a aplicação
    }

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

        
        setupObjects(); //Adiciona os objetos a Array gameObjects;

        LongValue lastNanoTime = new LongValue(System.nanoTime()); //Obtem o tempo atual, classe LongValue apenas para evitar erro de contexto estatico
        new Draw(lastNanoTime).start(); //Loop da logica do jogo, essa função é chamada a cada frame

        stage.show(); //Exibe a GUI do jogo
    }

    private void setupObjects() {
        uiObject.add(ga);
        uiObject.add(ui);
        mapObject.add(map);
    }

    private static class keyPressed implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent e) {
            String code = e.getCode().toString();

            if (!input.contains(code)) { //Evita duplicatas
                input.add(code);
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


}
