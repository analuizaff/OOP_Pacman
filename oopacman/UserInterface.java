package oopacman;

import java.io.File;
import java.io.InputStream;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class UserInterface implements UIObject {

        private int score;
        private double x, y;
        
        public UserInterface(double x, double y, int score) {
            this.x = x;
            this.y = y;
            this.score = score;
        }

        public int getScore() {
                return this.score;
        }

        public void addScore(int score) {
                this.score += score;
        }

        @Override
        public void render(GraphicsContext gc, double time ){
            gc.save();
            gc.translate(this.x,this.y);
            gc.setFill(new Color(1,1,1,1));
            gc.setFont(Font.font("Tahoma", 30));
            
            gc.fillText("SCORE\n"+getScore(), 30, 30);
            gc.restore();
            
        }


        public void update( GraphicsContext gc, double time ){

        }
}