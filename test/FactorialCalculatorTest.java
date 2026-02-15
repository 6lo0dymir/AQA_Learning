import org.testng.annotations.*;
import org.testng.Assert;


public class FactorialCalculatorTest {

    @BeforeClass()
    static void initAll() {
        System.out.println("Начало тестирования FactorialCalculator");
    }

    @AfterClass()
    static void tearDownAll() {
        System.out.println("Завершение тестирования FactorialCalculator");
    }

    @BeforeMethod()
    public void setUp() {
        System.out.println("Запуск теста");
    }

    @AfterMethod()
    public void tearDown() {
        System.out.println("Тест завершен");
    }

    @Test(priority = 1, description = "Тест 1. ФАкториал 0 = 1")
    public void testFactorialZero() {
        long result = FactorialCalculator.calculateFactorial(0);
        Assert.assertEquals(result, 1l, "Факториал 0 должен быть 1");
    }

    @Test(priority = 2, description = "Тест 2. Факториал 1 = 1")
    public void testFactorialOfOne() {
        long result = FactorialCalculator.calculateFactorial(1);
        Assert.assertEquals(result, 1L, "Факториал 1 должен быть 1");
    }

    @Test(priority = 3, description = "Тест 3. Факториал 5 = 120")
    public void testFactorialOfFive() {
        long result = FactorialCalculator.calculateFactorial(5);
        Assert.assertEquals(result, 120L, "Факториал 5 должен быть 120");
    }

    @Test(priority = 4, description = "Тест 4. Факториал 10 = 3628800")
    public void testFactorialOfTen() {
        long result = FactorialCalculator.calculateFactorial(10);
        Assert.assertEquals(result, 3628800L, "Факториал 10 должен быть 3628800");
    }

    @Test(priority = 5, description = "Тест 5. Факториал 20 (максимальное значение)")
    public void testFactorialOfTwenty() {
        long result = FactorialCalculator.calculateFactorial(20);
        Assert.assertEquals(result, 2432902008176640000L,
                "Факториал 20 должен быть 2432902008176640000");
    }

    @Test(priority = 6, description = "Тест 6. Отрицательное число (должно быть исключение)")
    public void testNegativeInput() {
        try {
            FactorialCalculator.calculateFactorial(-5);
            Assert.fail("Должно было быть исключение для отрицательного числа");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(),
                    "Факториал отрицательного числа не определен",
                    "Неверное сообщение об ошибке");
        }
    }

    @Test(priority = 7, description = "Тест 7. Слишком большое число (должно быть исключение)")
    public void testTooLargeInput() {
        try {
            FactorialCalculator.calculateFactorial(21);
            Assert.fail("Должно было быть исключение для числа > 20");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(),
                    "Слишком большое число (макс. 20 для типа long)",
                    "Неверное сообщение об ошибке");
        }
    }

    @Test(priority = 8, description = "Тест 8. Рекурсия: факториал 0 = 1")
    public void testRecursiveFactorialOfZero() {
        long result = FactorialCalculator.calculateFactorialRecursive(0);
        Assert.assertEquals(result, 1L, "Рекурсивный метод: факториал 0 должен быть 1");
    }

    @Test(priority = 9, description = "Тест 9. Рекурсия: факториал 5 = 120")
    public void testRecursiveFactorialOfFive() {
        long result = FactorialCalculator.calculateFactorialRecursive(5);
        Assert.assertEquals(result, 120L, "Рекурсивный метод: факториал 5 должен быть 120");
    }

    @Test(priority = 10, description = "Тест 10. Рекурсия: отрицательное число (исключение)")
    public void testRecursiveNegativeInput() {
        try {
            FactorialCalculator.calculateFactorialRecursive(-3);
            Assert.fail("Рекурсивный метод: должно быть исключение для отрицательного числа");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(),
                    "Факториал отрицательного числа не определен",
                    "Неверное сообщение об ошибке");
        }
    }


}