public class ArithmeticCalculator {
    public static void main(String[] args) {

    }

    public static int calculateSum(int a, int b) {
        return a + b;
    }

    public static int calculateSubtraction(int a, int b) {
        return a - b;
    }

    public static int calculateMultiply(int a, int b) {
        return a * b;
    }
    public static int calculateDivide(int a, int b){
        if ( b == 0){
            throw new ArithmeticException("На ноль делить нельзя!");
        }
        return a/b;
    }
}
