package Geometry.java;

public class Main {

    public static void main(String[] args) {
        Point P1 = new Point(1f,1f);
        Point P2 = new Point(2f,2f);
        System.out.println(P1);
        Line L1 = new Line(P1,P2);
        System.out.println(L1);
    }
}
