public interface PointCP6{

  double getX();
  double getY();
  double getRho();
  double getTheta();
  double getDistance(PointCP pointB);
  PointCP2 rotatePoint(double rotation);

}
