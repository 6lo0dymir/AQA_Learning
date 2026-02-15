import org.testng.annotations.*;
import org.testng.Assert;

public class TriangleAreaCalculateTest {
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

    @Test(priority = 1, description = "Правильный треугольник"){
       public void
    }

}