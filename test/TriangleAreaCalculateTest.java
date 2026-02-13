import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaCalculateTest {

    @BeforeAll
    static void initAll(){
        System.out.println("Начало тестирования TriangleAreaCalculate");
    }

    @AfterAll
    static void tearDownAll(){
        System.out.println("Тестирование TriangleAreaCalculate закончено");
    }

    @BeforeEach
    void setUp(){
        System.out.println("Запуск теста");
    }
    @AfterEach
    void tearDown(){
        System.out.println("Тест завершен");
    }

    @Test
    @DisplayName("Тест 1. Существующий треугольник")
    void testExistTriangleIsExist(){
        assertEquals(30, TriangleAreaCalculate.calculateByHeron(5,12,13));
    }
    @Test
    @DisplayName("Тест 2. Треугольник с нулевой стороной")
    void testTriangleWithNullSide(){
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculate.calculateByHeron(0,4,5));
    }
    @Test
    @DisplayName("Тест 3. Треугольник с отрицательной стороной")
    void testTriangleWithNegativeSide(){
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculate.calculateByHeron(-5,12,13));
    }
    @Test
    @DisplayName("Тест 4. Несуществующий треугольник")
    void testTriangleNotExist(){
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculate.calculateByHeron(1,2,4));
    }
    @ParameterizedTest
    @DisplayName("Тест 5. Граничные значения")
    @CsvSource({
            "1, 1, 1.999, 0.031",
            "100, 100, 0.001, 0.05"
    })
    void testEdgeCases(double a, double b, double c, double expected) {
        assertEquals(expected,
                TriangleAreaCalculate.calculateByHeron(a, b, c), 0.01);
    }



}