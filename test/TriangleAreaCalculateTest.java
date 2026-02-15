import org.testng.Assert;
import org.testng.annotations.*;

public class TriangleAreaCalculateTest {
    @BeforeClass
    static void initAll() {
        System.out.println("Начало тестирования FactorialCalculator");
    }

    @AfterClass
    static void tearDownAll() {
        System.out.println("Завершение тестирования FactorialCalculator");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Запуск теста");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Тест завершен");
    }

    @Test(priority = 1, description = "Тест 1. Прямоугольный треугольник")
       public void testTriangle3_4_5(){
        double result = TriangleAreaCalculate.calculateByHeron(3,4,5);
        Assert.assertEquals(result,6.0,0.01);
    }
    @Test(priority = 2, description = "Тест 2. Равнобедренный треугольник")
    public void testEqualSidesTriangle(){
        double result = TriangleAreaCalculate.calculateByHeron(5,5,6);
        Assert.assertEquals(result, 12.0,0.01);
    }
    @Test(priority = 3, description = "Тест 3. Равносторонний треугольник")
    public void testAllSidesAreEqual(){
        double result = TriangleAreaCalculate.calculateByHeron(6,6,6);
        Assert.assertEquals(result, 15.58,0.01);
    }
    @Test(priority = 4, description = "Тест 4. Минимальные стороны")
    public void testMinimalSides(){
        double result = TriangleAreaCalculate.calculateByHeron(0.0001,0.0001,0.0001);
        Assert.assertEquals(result, 0,0.000001);
    }
    @Test(priority = 5, description = "Тест 5. Треугольник с нулевой стороной")
    public void testZeroSide(){
        Assert.assertThrows(IllegalArgumentException.class, ()-> TriangleAreaCalculate.calculateByHeron(10,12,0));
    }
    @Test(priority = 6, description = "Тест 6. Отрицательная сторона")
    public void testNegativeSide(){
        Assert.assertThrows(IllegalArgumentException.class, ()-> TriangleAreaCalculate.calculateByHeron(-10,12,20));
    }
    @Test(priority = 7, description = "Тест 7. Несуществующий треугольник")
    public void testTriangleNotExist(){
        Assert.assertThrows(IllegalArgumentException.class, ()-> TriangleAreaCalculate.calculateByHeron(1,2,5));
    }





}