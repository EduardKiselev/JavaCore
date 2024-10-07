public interface Shape {
    double perimeter(); // периметр
    double area(); // площадь
    boolean equals(Shape another); //совпадает ли эта фигура с другой как множество точек. (В частности, треугольник ABC равен треугольнику BCA.)
    boolean isCongruentTo(Shape another); // равна ли эта фигура другой в геометрическом смысле, то есть можно ли совместить эти фигуры движением плоскости. Движение — это отображение плоскости на себя, сохраняющее расстояния.
    boolean isSimilarTo(Shape another); // подобна ли эта фигура другой, то есть можно ли перевести одну фигуру в другую преобразованием подобия. (Определение преобразования подобия, кто не знает, можно посмотреть в Википедии.)
    boolean containsPoint(Point point); //находится ли точка внутри фигуры.

    void rotate(Point center, double angle); // поворот на угол (в градусах, против часовой стрелки) относительно точки
    void reflect(Point center); // симметрию относительно точки
    void reflect(Line axis); // симметрию относительно прямой
    void scale(Point center, double coefficient); // гомотетию с коэффициентом coefficient и центром center
}
