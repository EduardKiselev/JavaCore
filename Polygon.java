public class Polygon {
    static final double EPS = Math.pow(10,-8);
    Point[] vertices;
    Polygon(Point[] points){
        this.vertices = points;
    }
    Polygon(String args){
        String[] points = args.split(",");
        int N = points.length/2;
        Point[] res = new Point[N];
        for (int i=0;i< points.length;i+=2){
            double x = Double.parseDouble(points[i]);
            double y = Double.parseDouble(points[i+1]);
            res[i] = new Point(x,y);
        }
        this.vertices = res;
    }
    public int verticeCount(){
        return vertices.length;
    }
    public Point[] vertices(){
        return this.vertices;
    }
    public boolean isConvex(){
        //Sum of angels in convex polygon is 180*(n-2) where n is a number of edges
        var points = this.vertices;
        double sumOfAngles = 0;
        Point prev = points[points.length-2];
        Point curr = points[points.length-1];
        for(int i=0;i<points.length;i++){
            Point next = points[i];
            Line first = new Line(curr,prev);
            Line second = new Line(curr,next);
            Angle currAngle = new Angle(first, second);
            double dergees = currAngle.Value();
            sumOfAngles += dergees;
            prev = curr;
            curr = next;
        }
        return Math.abs(sumOfAngles - (this.verticeCount() - 2) * 180) < EPS;
    }
}
