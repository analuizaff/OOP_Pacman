package oopacman;

public class Path implements Entity  {
  private boolean capturado = false;
  
  public Path (int x, int y){
    super(x, y, "Path");
  }
  
  public void setCapturado(){
    capturado = true;   
  
  }
}
