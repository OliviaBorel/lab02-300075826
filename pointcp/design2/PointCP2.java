package design2;
import design3.PointCP3;

public class PointCP2 implements PointCP6
{
  private double rho;
  private double theta;


  public PointCP2(double rho, double theta){
    this.rho = rho;
    this.theta = theta;
  }


  public double getX(){
      return (Math.cos(Math.toRadians(theta)) * rho);
  }

  public double getY(){
      return (Math.sin(Math.toRadians(theta)) * rho);
  }

  public double getRho(){
    return rho;
  }

  public double getTheta(){
    return theta;
  }


  public PointCP2 convertStorageToPolar(){
    return new PointCP2(rho, theta);
  }

//sould be POINTCP3!!
  public PointCP2 convertStorageToCartesian(){

      //Calculate X and Y
      double temp = getX();
      theta = getY();
      rho = temp;

      return new PointCP2(rho, theta);
  }


  public double getDistance(PointCP2 pointB)
  {
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY();

    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }


  public PointCP2 rotatePoint(double rotation)
  {
    //double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();

    return new PointCP2(
      (Math.cos(rotation) * X) - (Math.sin(rotation) * Y),
      (Math.sin(rotation) * X) + (Math.cos(rotation) * Y));
  }


  public String toString()
  {
    /*return "Stored as " + (typeCoord == 'C'
       ? "Cartesian  (" + getX() + "," + getY() + ")"
       : "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
      */
    return "Cartesian (" +getX()+ "," +getY()+ ")";
  }


  public void main(String[] args) {
      PointCP2 convert = convertStorageToPolar();
      System.out.println(convert.getRho() + convert.getTheta());
  }
}
