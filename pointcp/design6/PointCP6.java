public interface PointCP6{

  double getX();
  double getY();
  double getRho();
  double getTheta();
  //public PointCP2 convertStorageToPolar();
  //public PointCP3 convertStorageToCartesian();
  double getDistance(PointCP pointB);
  PointCP2 rotatePoint(double rotation);
  //public String toString();

}
