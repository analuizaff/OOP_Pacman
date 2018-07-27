package oopacman;

import static oopacman.OOPacman.input;

/**
 * Class
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
        
        public static boolean isPressed(Key key) {
            return input.contains(key.toString());
        }
    }
