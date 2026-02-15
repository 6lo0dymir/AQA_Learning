import org.testng.*;
import org.testng.annotations.*;

public class CompareNumbersTest {
    @BeforeClass
    static void initAll() {
        System.out.println("Начало тестирования CompareNumbers");
    }

    @AfterClass
    static void tearDownAll() {
        System.out.println("Завершение тестирования CompareNumbers");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Запуск теста");
    }

    @AfterMethod
    public void tearDown() {System.out.println("Тест завершен");}

    @DataProvider
    public Object[][] equalNumbers (){
        return new Object[][]{
                {1,1,true},
                {1,2,false},
                {0,0,true},
                {-1,-1,true},
                {-1,1,false},
                {100,100,true}
        };
    }
    @Test (priority = 1, description = "Тест 1. Равенство чисел", dataProvider = "equalNumbers")
    public void testEqualNumber(int a, int b, boolean expected){
        Assert.assertEquals(CompareNumbers.isEqual(a,b), expected);
    }
    @DataProvider
    public Object[][] notEqualNumbers (){
        return new Object[][]{
                {1,2,true},
                {1,1,false},
                {0,0,false},
                {-1,-1,false},
                {-1,1,true},
                {100,200,true}
        };
    }
    @Test (priority = 2, description = "Тест 2. Неравенство чисел", dataProvider = "notEqualNumbers")
    public void testNotEqualNumber(int a, int b, boolean expected){
        Assert.assertEquals(CompareNumbers.notEqual(a,b), expected);
    }
    @DataProvider
    public Object[][] isGreaterNumbers (){
        return new Object[][]{
                {3,2,true},
                {1,1,false},
                {1,0,true},
                {-1,-1,false},
                {-1,-4,true},
                {300,200,true}
        };
    }
    @Test (priority = 3, description = "Тест 3. Число 'а' старше", dataProvider = "isGreaterNumbers")
    public void testisGreaterNumber(int a, int b, boolean expected){
        Assert.assertEquals(CompareNumbers.isGreater(a,b), expected);
    }
    @DataProvider
    public Object[][] isGreaterOrEqualNumbers (){
        return new Object[][]{
                {3,2,true},
                {1,1,true},
                {0,4,false},
                {-4,-1,false},
                {-1,-4,true},
                {300,300,true}
        };
    }
    @Test (priority = 4, description = "Тест 4. Число 'а' старше или равно", dataProvider = "isGreaterOrEqualNumbers")
    public void testisGreaterOrEqualNumber(int a, int b, boolean expected){
        Assert.assertEquals(CompareNumbers.isGreaterOrEqual(a,b), expected);
    }
    @DataProvider
    public Object[][] isLesserNumbers (){
        return new Object[][]{
                {2,5,true},
                {1,1,false},
                {0,4,true},
                {-4,-1,true},
                {-1,-4,false},
                {300,400,true}
        };
    }
    @Test (priority = 4, description = "Тест 4. Число 'а' меньше", dataProvider = "isLesserNumbers")
    public void testisLesserNumber(int a, int b, boolean expected){
        Assert.assertEquals(CompareNumbers.isLesser(a,b), expected);
    }
    @DataProvider
    public Object[][] isLesserOrEqualNumbers (){
        return new Object[][]{
                {2,5,true},
                {1,1,true},
                {4,0,false},
                {-1,-1,true},
                {-1,-4,false},
                {500,500,true}
        };
    }
    @Test (priority = 5, description = "Тест 5. Число 'а' меньше или равно", dataProvider = "isLesserOrEqualNumbers")
    public void testisLesserOrEqualNumber(int a, int b, boolean expected){
        Assert.assertEquals(CompareNumbers.isLesserOrEqual(a,b), expected);
    }
    @DataProvider
    public Object[][] getMaxNumbers (){
        return new Object[][]{
                {2,5,5},
                {1,1,1},
                {4,0,4},
                {-1,0,0},
                {-1,-4,-1},
                {500,1200,1200}
        };
    }
    @Test (priority = 6, description = "Тест 6. Найти максимальное число", dataProvider = "getMaxNumbers")
    public void testGetMaxNumber(int a, int b, int expected) {
        Assert.assertEquals(CompareNumbers.getMax(a, b), expected);
    }
    @DataProvider
    public Object[][] getMinNumbers (){
        return new Object[][]{
                {2,5,2},
                {1,1,1},
                {4,0,0},
                {-1,0,-1},
                {-1,-4,-4},
                {500,1200,500}
        };
    }
    @Test (priority = 6, description = "Тест 7. Найти минимальное число", dataProvider = "getMinNumbers")
    public void testGetMinNumber(int a, int b, int expected) {
        Assert.assertEquals(CompareNumbers.getMin(a, b), expected);
    }

}