package oopacman;
 
public class Wall implements Entity{
  
  public Wall(int x, int y) {
        super(x, y, "Wall");
        setSize(10);
  }
  
      @Override
    public void render(GraphicsContext gc, double time) {
        gc.setFill(new Color(0, 0, 1.00 , 1.00));
        gc.setStroke(new Color(0,0,1,1));
        gc.fillOval(getX(), getY(), getSize(), getSize());
        gc.strokeOval(getX(), getY(), getSize(), getSize());
}

}
