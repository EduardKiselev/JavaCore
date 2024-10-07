public class Line {
    Point point;
    double angular;
    Point OyIntersectPoint;

    Line(Point p1, Point p2){
        this.point = p1;
        if(p2.x()!=p1.x()) {
            this.angular = (p2.y() - p1.y()) / (p2.x() - p1.x());
            this.OyIntersectPoint = new Point(p1.x(), p1.y() - angular * p1.x());
        }
        else{
            this.angular = Double.MAX_VALUE;
            if(p2.x() == 0){
               this.OyIntersectPoint = new Point(0,0);
            }
            else{
                this.OyIntersectPoint = Point.EMPTY;
            }
        }

    }
    Line(Point p1, double angular){
        this.point = p1;
        this.angular = angular;
        this.OyIntersectPoint = new Point(p1.x(), p1.y() - angular * p1.x());
    }
    public static Point Intersect(Line first, Line second){
        if(first.angular == Double.MAX_VALUE && second.angular == Double.MAX_VALUE) {
                if(first.point.x() != second.point.x()) return Point.EMPTY;
                else{
                    return first.point;
                }
            }
        if(first.angular == Double.MAX_VALUE || second.angular == Double.MAX_VALUE) {
            double xi = 0, yi = 0;
            if (first.angular == Double.MAX_VALUE) {
                xi = first.point.x();
                yi = second.OyIntersectPoint.y() + first.angular * xi;
            }
            if (second.angular == Double.MAX_VALUE) {
                xi = second.point.x();
                yi = first.OyIntersectPoint.y() + first.angular * xi;
            }
            return new Point(xi, yi);
        }
        if(first.angular == second.angular){

            if(first.OyIntersectPoint.equals(second.OyIntersectPoint)){
                return first.OyIntersectPoint;
            }
            else{
                return Point.EMPTY;
            }
        }else{
            double xi = - (first.OyIntersectPoint.y()-second.OyIntersectPoint.y()) / (first.angular - second.angular);
            double yi = first.angular * xi + first.OyIntersectPoint.y();
            return new Point(xi,yi);
            }
    }
}
