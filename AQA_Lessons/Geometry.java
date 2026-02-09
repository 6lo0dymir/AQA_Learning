import java.awt.Color;

public class Geometry {
    public static void main(String[] args) {
        Circle circle1 = new Circle(10, Color.yellow, Color.green);
        circle1.printInfo();
        Rectangle rectangle1 = new Rectangle(12, 15);
        rectangle1.printInfo();
        Triangle triangle1 = new Triangle(12,10,5);
        triangle1.printInfo();

    }
}
//Интерфейс//
interface GeometricShape{
    double calculatePerimeter();
    double calculateArea();

    default Color getFillColor(){
        return Color.white;
    }
    default Color getLineColor(){
        return Color.black;
    }

    default void setFillColor (Color color){

    }
    default  void setLineColor (Color color){

    }
    default void printInfo(){
        System.out.println("Периметр "+ String.format("%.2f", calculatePerimeter()));
        System.out.println("Площадь " + String.format("%.2f", calculateArea()));
        System.out.println("Цвет заливки " + getFillColor());
        System.out.println("Цвет линий " + getLineColor());
        System.out.println();
    }
}
//Общий абстрактный класс для фигур//
abstract class Figures implements GeometricShape{
    protected Color fillColor;
    protected Color lineColor;

    public Figures (Color fillColor, Color lineColor){
        this.fillColor = fillColor != null ? fillColor : Color.white;
        this.lineColor = lineColor != null ? lineColor : Color.black;
    }
    @Override
    public Color getFillColor(){
        return fillColor;
    }
    @Override
    public Color getLineColor(){
        return lineColor;
    }
    @Override
    public void setFillColor(Color color){
        if (color != null){
            this.fillColor = color;
        }
    }
    @Override
    public void setLineColor (Color color){
        if (color != null){
            this.lineColor = color;
        }
    }
}
//Класс Круг//
class Circle extends Figures{
    private double radius;

    public Circle(double radius, Color fillColor, Color lineColor){
        super(fillColor, lineColor);
        this.radius = Math.max(radius, 0);
    }
    public Circle (double radius){
        this (radius, Color.blue, Color.red);
    }
    @Override
    public double calculatePerimeter(){
        return 2 * Math.PI * radius;
    }
    @Override
    public double calculateArea(){
        return Math.PI * Math.pow(radius, 2);
    }
    public void setRadius (double radius){
        this.radius = Math.max(radius, 0);
    }
    public double getRadius (){
        return radius;
    }
    @Override
    public void printInfo(){
        System.out.println("Это круг");
        System.out.println("Его радиус " + String.format("%.2f", radius));
        super.printInfo();
    }
}
//Класс прямоугольник//
class Rectangle extends Figures{
    private double height;
    private double weight;

    public Rectangle(double height, double weight, Color fillColor, Color lineColor){
        super (fillColor, lineColor);
        this.height = Math.max(height, 0);
        this.weight = Math.max(weight, 0);
    }
    public Rectangle(double height, double weight){
        this (height, weight, Color.blue, Color.yellow);
    }
    @Override
    public double calculatePerimeter(){
        return 2 * (height + weight);
    }
    @Override
    public double calculateArea(){
        return height*weight;
    }
    public void setHeight (double height){
        this.height = Math.max(height, 0);
    }
    public void setWeight (double weight) {
        this.weight = Math.max(weight, 0);
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }
    @Override
    public void printInfo(){
        System.out.println("Это прямоугольник");
        System.out.println("Высота " + String.format("%.2f", height ));
        System.out.println("Ширина " + String.format("%.2f", weight));
        super.printInfo();
    }
}
//Класс Треугольник//
class Triangle extends Figures{
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle (double sideA, double sideB, double sideC, Color fillColor, Color lineColor){
        super(fillColor, lineColor);
        this.sideA = Math.max(sideA, 0);
        this.sideB = Math.max(sideB, 0);
        this.sideC = Math.max(sideC, 0);

    }
    public Triangle (double sideA, double sideB, double sideC){
        this(sideA, sideB, sideC, Color.green, Color.red);
    }
    @Override
    public double calculatePerimeter(){
        return sideA+sideB+sideA;
    }
    @Override
    public double calculateArea(){
        double p = calculatePerimeter();
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }
    @Override
    public void printInfo(){
        System.out.println("Это треугольник");
        System.out.println("Его стороны: А - " + String.format("%.2f", sideA) + " B - " + String.format("%.2f", sideB)
        + " C - " + String.format("%.2f", sideC));
        super.printInfo();
    }
}
