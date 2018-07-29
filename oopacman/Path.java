package oopacman;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Path extends StaticEntity {

    private boolean capturado = false;

    public Path(int x, int y) {
        super(x, y, "Path");
        setSize((int) Math.floor(OOPacman.ga.getWidth()/15));
    }

    public void capturar(){
        this.capturado = true;
    }

    public boolean getCapturado(){
        return this.capturado;
    }

    @Override
    public void render(GraphicsContext gc, double time) {
        gc.setFill(new Color(0.00, 0.00, 0.00, 1.0));//não sei colocar cor, precisa mudar a cor se capturado == true
        gc.setStroke(new Color(1,1,1,1));
        gc.fillRect(getX(), getY(), getSize(), getSize());
        gc.strokeRect(getX(), getY(), getSize(), getSize());
    }

    @Override
    public void update(GraphicsContext gc, double time) {
        //deve mudar caso this.capturado ser true
    }



}