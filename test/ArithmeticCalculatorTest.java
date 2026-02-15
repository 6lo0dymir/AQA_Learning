import org.testng.*;
import org.testng.annotations.*;

public class ArithmeticCalculatorTest {
    @BeforeClass
    static void initAll() {
        System.out.println("Начало тестирования ArithmeticCalculator");
    }

    @AfterClass
    static void tearDownAll() {
        System.out.println("Завершение тестирования ArithmeticCalculator");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Запуск теста");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Тест завершен");
    }

    @DataProvider
    public Object [][] sumNumbers (){
        return new Object[][]{
                {1,2,3},
                {-1,1,0},
                {0,0,0},
                {10,-5,5},
                {-3,-7,-10},
                {100,100,200}
        };
    }
    @Test (priority = 1, description = "Параметризированный тест сложения", dataProvider = "sumNumbers")
    public void testAdd(int a, int b, int expected){
        int result = ArithmeticCalculator.calculateSum(a,b);
        Assert.assertEquals(result, expected);
    }
    @DataProvider
    public Object [][] subtractionNumbers (){
        return new Object[][]{
                {2,1,1},
                {-1,1,-2},
                {0,0,0},
                {10,-5,15},
                {-3,-7,4},
                {100,100,0}
        };
    }
    @Test (priority = 2, description = "Параметризированный тест вычитания", dataProvider = "subtractionNumbers")
    public void testSubtract(int a, int b, int expected){
        int result = ArithmeticCalculator.calculateSubtraction(a,b);
        Assert.assertEquals(result, expected);
    }
    @DataProvider
    public Object [][] multiplyNumbers(){
        return new Object[][]{
                {2,3,6},
                {2,-3,-6},
                {-2,-3,6},
                {0,5,0},
                {1,100,100},
                {10,0,0}
        };
    }
    @Test (priority = 3, description = "Параметризированный тест умножения", dataProvider = "multiplyNumbers")
    public void testMultiply(int a, int b, int expected){
        int result = ArithmeticCalculator.calculateMultiply(a,b);
        Assert.assertEquals(result, expected);
    }
    @DataProvider
    public Object [][] divideNumbers(){
        return new Object[][]{
                {10,2,5},
                {9,2,4},
                {-10,2,-5},
                {10,-2,-5},
                {-10,-2,5},
                {0,2,0}
        };
    }
    @Test (priority = 4, description = "Параметризированный тест деления", dataProvider = "divideNumbers")
    public void testDivide(int a, int b, int expected) {
        int result = ArithmeticCalculator.calculateDivide(a, b);
        Assert.assertEquals(result, expected);
    }
    @Test (priority = 5, description = "Тест деления на ноль")
    public void testDivideByZero(){
        Assert.assertThrows(ArithmeticException.class,()->ArithmeticCalculator.calculateDivide(5,0));
    }

}