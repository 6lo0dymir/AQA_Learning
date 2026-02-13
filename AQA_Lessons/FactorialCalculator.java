public class FactorialCalculator {
    public static void main(String[] args) {

    }

    public static long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не определен");
        }
        if (n > 20) {
            throw new IllegalArgumentException("Слишком большое число (макс. 20 для типа long)");
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    public static long calculateFactorialRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не определен");
        }
        if (n > 20) {
            throw new IllegalArgumentException("Слишком большое число (макс. 20 для типа long)");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calculateFactorialRecursive(n - 1);
    }
}

