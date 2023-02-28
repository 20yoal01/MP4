
public class Point
  {
  private double x,y;
  
  public Point(double x, double y)
    {
    setX(x);
    setY(y);
    }
  
  public Point(Point point)
    {
    moveTo(point);
    }
  
  public double getX()
    {
    return x;
    }
  
  public double getY()
    {
    return y;
    }
  
  public void setX(double x)
    {
    this.x=x;
    }
  
  public void setY(double y)
    {
    this.y=y;
    }
  
  public void move(double dx, double dy)
    {
    setX(getX()+dx);
    setY(getY()+dy);
    }
  
  public void moveTo(Point point)
    {
    setX(point.getX());
    setY(point.getY());
    }
  
  public double distanceTo(Point other)
    {
    double dx = this.x-other.x;
    double dy = this.y-other.y;
    return Math.sqrt(dx*dx+dy*dy);
    }
  }
