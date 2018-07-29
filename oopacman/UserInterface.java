package oopacman;

import javafx.scene.canvas.GraphicsContext;

public class UserInterface implements UIObject {

        private int score;

        public UserInterface () {
                this.score = 0;
        }

        public int getScore() {
                return this.score;
        }

        public void addScore(int score) {
                this.score += score;
        }

        @Override
        public void render(GraphicsContext gc, double time ){
			
        }


        public void update( GraphicsContext gc, double time ){

        }
}