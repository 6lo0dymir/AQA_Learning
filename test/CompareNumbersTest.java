import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CompareNumbersTest {
    @BeforeAll
    static void initAll() {
        System.out.println("Начало тестирования CompareNumbers");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Тестирование CompareNumbers окончено");
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
    @DisplayName("Тест 1. Равенство")
    @CsvSource ({"1,1,true",
    "1,2,false",
    "0,0,true",
    "-1,-1, true",
    "-1,1,false"})
    void testEqual (int a, int b, boolean expected){
        assertEquals(expected, CompareNumbers.isEqual(a,b));
    }

    @ParameterizedTest
    @DisplayName("Тест 2. Неравнество")
    @CsvSource({"2,1,true",
    "1,2,true",
    "0,0,false",
    "-1,-1,false",
    "-1,1,true"})
    void testNotEqual(int a, int b, boolean expected){
        assertEquals(expected,CompareNumbers.notEqual(a,b));
    }
    @ParameterizedTest
    @DisplayName("Тест 3. Число 'a' больше")
    @CsvSource({"5,3,true",
    "3,5,false",
    "1,0,true",
    "-1,0,false",
    "-1,-3,true"})
    void testIsGreater(int a, int b, boolean expected){
        assertEquals(expected, CompareNumbers.isGreater(a,b));
    }
    @ParameterizedTest
    @DisplayName("Тест 4. Число 'a' больше или равно")
    @CsvSource({"5,3,true",
    "3,5,false",
    "7,7,true",
    "-3,-1,false",
    "-3,-3,true"})
    void testIsGreaterOrEqual (int a, int b, boolean expected){
        assertEquals(expected,CompareNumbers.isGreaterOrEqual(a,b));
    }
    @ParameterizedTest
    @DisplayName("Тест 5. Число 'a' меньше")
    @CsvSource({"3,5,true",
    "5,3,false",
    "0,3,true",
    "-1,-3,false",
    "-5,-3,true"})
    void testIsLesser (int a, int b, boolean expected){
        assertEquals(expected, CompareNumbers.isLesser(a,b));
    }
    @ParameterizedTest
    @DisplayName("Тест 6. Число 'а' меньше или равно")
    @CsvSource({"3,5,true",
    "3,3,true",
    "3,0,false",
    "-1,-1,true",
    "-3,-5,false"})
    void testIsLesserOrEqual (int a, int b, boolean expected){
        assertEquals(expected, CompareNumbers.isLesserOrEqual(a,b));
    }
    @ParameterizedTest
    @DisplayName("Тест 7. Какое число больше")
    @CsvSource({"1,2,2",
    "2,3,3",
    "0,1,1",
    "-1,0,0",
    "-1,-5,-1"})
    void testGetMaxNumber(int a, int b, int expected){
        assertEquals(expected, CompareNumbers.getMax(a,b));
    }
    @ParameterizedTest
    @DisplayName("Тест 8. Какое число меньше")
    @CsvSource({"1,2,1",
            "2,3,2",
            "0,1,0",
            "-1,0,-1",
            "-1,-5,-5"})
    void testGetMinNumber(int a, int b, int expected){
        assertEquals(expected,CompareNumbers.getMin(a,b));
    }

}