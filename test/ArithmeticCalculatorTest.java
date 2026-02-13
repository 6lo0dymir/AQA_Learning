import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticCalculatorTest {
    @BeforeAll
    static void initAll() {
        System.out.println("Начало тестирования ArithmeticCalculator");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Тестирование ArithmeticCalculator закончено");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Запуск теста");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Тест завершен");
    }

    @ParameterizedTest
    @DisplayName("Тест 1. Сложение")
    @CsvSource({"1,2,3",
            "-1,1,0",
            "0,0,0",
            "-3,-4,-7",
            "100, 200, 300"})
    void testCalculatedSum(int a, int b, int expected) {
        assertEquals(expected, ArithmeticCalculator.calculateSum(a, b));
    }

    @ParameterizedTest
    @DisplayName("Тест 2. Вычитание")
    @CsvSource({"3,2,1",
            "0,3,-3",
            "2,3,-1",
            "-2,-3,1",
            "100,100,0"})
    void testCalculatedSubtraction(int a, int b, int expected) {
        assertEquals(expected, ArithmeticCalculator.calculateSubtraction(a, b));
    }

    @ParameterizedTest
    @DisplayName("Тест 3. Умножение")
    @CsvSource({"2,3,6",
            "3,0,0",
            "100,2,200",
            "-2,3,-6",
            "-2,-3,6"})
    void testCalculatedMultiple(int a, int b, int expected) {
        assertEquals(expected, ArithmeticCalculator.calculateMultiply(a, b));
    }

    @ParameterizedTest
    @DisplayName("Тест 4. Деление")
    @CsvSource({"10,2,5",
            "7,2,3",
            "0,2,0",
            "-20,5,-4",
            "100, 25, 4"})
    void testCalculatedDivide(int a, int b, int expected) {
        assertEquals(expected, ArithmeticCalculator.calculateDivide(a, b));
    }
    @Test
    @DisplayName("Тест 5. Деление на ноль")
    void testDivideByZero(){
        assertThrows(ArithmeticException.class,()-> ArithmeticCalculator.calculateDivide(5,0));
    }
}