import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialCalculatorTest {
    @BeforeClass()
    public void setUp(){
        System.out.println("Начало тестирования FactorialCalculator");
    }
    @AfterClass()
    public void tearDown(){
        System.out.println("Завершение тестирования FactorialCalculator");
    }
    @BeforeMethod()
    public void

}