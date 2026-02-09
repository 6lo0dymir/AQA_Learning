public class ArrayIndexOutOfBoundsExceptionCatch {
    public static void main(String[] args) {

        int [] testArray = {1,2,3,4,5,6};
        System.out.println("Создан одномерный массив с индексами от 0 до " + (testArray.length-1));
        try{
            System.out.println("Вызываем индекс 6 (не существует)");
            int test = testArray [6];
            System.out.println("Значение " + test);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение " + e.getClass().getSimpleName());
            System.out.println("Сообщение " + e.getMessage());
        }
    }
}
