import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {


    @BeforeAll
    static void initAll(){
        System.out.println("Начало тестирования FactorialCalculator");
    }

    @AfterAll
    static void tearDownAll(){
        System.out.println("Тестирование окончено");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Запуск теста");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Тест завершен");
    }

    @Test
    @DisplayName("Тест 1. Факториал 0 = 1")
    void testFactorialIsZero(){
        assertEquals(1, FactorialCalculator.calculateFactorial(0));
        assertEquals(1, FactorialCalculator.calculateFactorialRecursive(0));
    }
    @Test
    @DisplayName("Тест 2. Факториал 1 = 1")
    void testFactorialIsOne(){
        assertEquals(1,FactorialCalculator.calculateFactorial(1));
        assertEquals(1,FactorialCalculator.calculateFactorialRecursive(1));
    }
    @ParameterizedTest
    @DisplayName("Тест 3. Факториалы от 2 до 10")
    @CsvSource({
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120",
            "6, 720",
            "7, 5040",
            "8, 40320",
            "9, 362880",
            "10, 3628800"
    })
    void testFactorialPositive(int input, long expected) {
        assertEquals(expected, FactorialCalculator.calculateFactorial(input));
        assertEquals(expected, FactorialCalculator.calculateFactorialRecursive(input));
    }

    @ParameterizedTest
    @DisplayName("Тест 4. Отрицательные числа выбрасывают исключение")
    @ValueSource(ints = {-1, -5, -10, -100})
    void testNegativeInputThrowsException(int n) {
        assertThrows(IllegalArgumentException.class,
                () -> FactorialCalculator.calculateFactorial(n));
        assertThrows(IllegalArgumentException.class,
                () -> FactorialCalculator.calculateFactorialRecursive(n));
    }

    @Test
    @DisplayName("Тест 5. Слишком большие числа выбрасывают исключение")
    void testTooLargeInputThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> FactorialCalculator.calculateFactorial(21));
        assertThrows(IllegalArgumentException.class,
                () -> FactorialCalculator.calculateFactorialRecursive(21));
    }


}