package oopacman;

public class Path implements Entity  {
  private boolean capturado = false;
  
  public Path (int x, int y){
    super(x, y, "Path");
    setSize(10);
  }
  
  public void setCapturado(){
    capturado = true;   
  
  }
  
  @Override
   public void render(GraphicsContext gc, double time) {
          gc.setFill(new Color(1.00, 1.00, 1.00, 1.0));
          gc.setStroke(new Color(0,0,0,1));
          gc.fillOval(getX(), getY(), getSize(), getSize());
          gc.strokeOval(getX(), getY(), getSize(), getSize());
   }
  
   @Override
   public void update(GraphicsContext gc, double time) {
        if (capturado) {
          gc.setFill(new Color(0, 0, 0, 0));
          gc.setStroke(new Color(0,0,0,0));
          gc.fillOval(getX(), getY(), getSize(), getSize());
          gc.strokeOval(getX(), getY(), getSize(), getSize())
        } else {
   }
  
}
