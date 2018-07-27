/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopacman;

/**
 *
 * @author Alexylva
 */
public enum Key {
        UP("UP"), DOWN("DOWN"), LEFT("LEFT"), RIGHT("RIGHT");

        private final String key;

        Key(String key) {
            this.key = key;
        }

        public String get() {
            return this.key;
        }
        
        @Override
        public String toString() {
            return get();
        }
    }
