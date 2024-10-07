public class Angle {
    final static Angle parallel = null;
    double value;
    Angle(Line first, Line second) {
        Point intersect = Line.Intersect(first, second);
        if (intersect != Point.EMPTY) {
            this.value = Math.tan(Math.abs(Math.atan(first.angular) - Math.atan(second.angular)));
        } else {

        }
    }
    public double Value() {
        return value;
    }
}
