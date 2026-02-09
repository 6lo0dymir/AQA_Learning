import java.util.Arrays;

public class Lesson_1 {
    public static void main(String[] args) {
        System.out.println("Вывод метода для задачи №1");
        printThreeWords();
        System.out.println();

        System.out.println("Вывод метода для задачи №2");
        checkSumSign();
        System.out.println();
    }
    //1. Вывод трех слов в столбец printThreeWords() //
    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    //2. Проверка положительной или отрицательной суммы checkSumSign()//
    public static void checkSumSign(){
        int a = 8;
        int b = 12;
        int sum = a+b;
        if (sum >= 0){
            System.out.println("Сумма положительная");
        }else{
            System.out.println("Сумма отрицательная");
        }
    }
    //3. Красный, желтый, зеленый printColor()//
    public static void printColor(){
        int value = 10;
        if (value<=0){
            System.out.println("Красный");
        } else if (value<=100){
            System.out.println("Желтый");
        } else
            System.out.println("Зеленый");
    }
    //4. Сравнение чисел compareNumbers()//
    public static void compareNumbers(){
        int a = 10;
        int b = 25;
        if (a>=b){
            System.out.println("a>=b");
        }else
            System.out.println("a<b");
    }
    //5. Проверка суммы чисел в диапазоне от 10 до 20(включительно)//
    public static boolean checkSumBoolean(int a, int b){
        int sum = a+b;
        return sum >= 10 && sum <= 20;
    }
    //6. Положительное или отрицательное число?//
    public static void checkPositiveNegative(int num){
        if (num>=0){
            System.out.println(num + " - Положительное число");
        } else
            System.out.println(num + " - Отрицательное число");
    }
    //7. Положительное или отрицательное число в булевом значении//
    public static boolean checkNumberBoolean(int num){
        return num < 0;
    }
    //8. Печать указанной строки указанное количество раз//
    public static void printMultipleStrings(String line, int mult){
        for (int i = mult; i>0;i--){
            System.out.println(line);
        }
    }
    //9. Определение високосного года //
    public static boolean yearIsLeapYear(int year){
        return (year%4==0 && year%100 !=0)||(year%400==0);
    }
    //10. Целочисленный массив из 0 и 1, циклом заменить 1 на 0 и 0 на 1//
    public static void invertArray(){
        int [] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Неинвертированный массив - "+ Arrays.toString(array));
        for (int i=0; i< array.length; i++){
            if (array[i]==0){
                array[i]=1;
            }else
                array[i]=0;

        }
        System.out.println("Инвертированный массив - "+ Arrays.toString(array));
    }
    //11. Пустой массив на 100 ячеек, заполнить числами через цикл//
    public static int[] fillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }
    //12. Задать массив. Пройти по нему циклом, все числа меньше 6 умножить на 2//
    public static void arrayMultipleOnTwo() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив - " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
        System.out.println("Измененный массив - " + Arrays.toString(array));
    }
    //13. Задать двухмерный массив. Заполнить диагональные элементы единицами
    public static int[][] sqareArrayFillDiagonals(int size){
        int [][] array = new int [size][size];
        for (int i = 0; i<size; i++){
            array[i][i]=1;
            array[i][size-1-i]=1;
        }
        return array;
    }
    /* 14. метод, принимающий на вход два аргумента: len и initialValue,
     и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue. */
    public static int[] twoArgumentsMassive (int len, int initialValue){
        int [] array = new int [len];
        for (int i = 0; i<len;i++){
            array[i]=initialValue;
        }
        return array;
    }


}