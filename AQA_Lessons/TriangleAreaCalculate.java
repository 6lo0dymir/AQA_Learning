public class TriangleAreaCalculate {
    public static void main(String[] args) {

        System.out.println("Правильный треугольник");
        System.out.println(calculateByHeron(1,2,5));


    }
    public static double calculateByHeron (double a, double b, double c){
        if (a <= 0 || b <= 0 || c <= 0){
            throw new IllegalArgumentException("Сторона не может быть равна 0 или отрицательной!");
        }
        if (a + b < c || a + c < b || b + c < a){
            throw new IllegalArgumentException("Такого треугольника не существует!");
        }
        double p = (a + b + c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }


}
