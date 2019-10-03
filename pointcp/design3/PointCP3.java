package design3;
import design2.PointCP2;

public class PointCP3 implements PointCP6
{

  private double x;
  private double y;


  public PointCP3(double x, double y){
    this.x = x;
    this.y = y;
  }


  public double getX(){
      return x;
  }

  public double getY(){
      return y;
  }

  public double getRho(){
      return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
  }

  public double getTheta(){
      return Math.toDegrees(Math.atan2(y, x));
  }


  public PointCP2 convertStorageToPolar(){
      //Calculate RHO and THETA
      double temp = getRho();
      y = getTheta();
      x = temp;

      return new PointCP2(x, y);
  }


  public PointCP3 convertStorageToCartesian(){
      return new PointCP3(x,y);
  }


  public double getDistance(PointCP3 pointB){
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY();

    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }


  public PointCP3 rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();

    return new PointCP3(
      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }


  public String toString()
  {
    return "Polar (" +getRho()+ "," +getTheta()+ ")";
  }
}
