/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOP_Pacman.oopacman;

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

        @Override
        public void update( GraphicsContext gc, double time ){

        }
}