public class Exeptions_Lesson {
    public static void main(String[] args) {
        String [][] correctArray = {
                {"1","2","3","4"},
                {"5","6","7","8"},
                {"9","10","11","12"},
                {"13","14","15","16"}
        };
        String [][] wrongSizeArray = {
                {"1","2","3","4"},
                {"5","6","7","8"},
                {"9","10","11","12"}
        };
        String [][] wrongDataArray = {
                {"1","2","3","4"},
                {"5","six","7","8"},
                {"9","10","11","12"},
                {"13","14","15","16"}
        };

        System.out.println("Тест 1 - корректный массив");
        try {
            int result = sumStringArray4x4(correctArray);
            System.out.println("Сумма: " + result);
        }catch (MyArrayDataException | MyArraySizeException e){
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("Тест 2 - массив некорректного размера");
        try {
            int result = sumStringArray4x4(wrongSizeArray);
            System.out.println("Сумма: " + result);
        }catch (MyArrayDataException | MyArraySizeException e){
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("Тест 3 - массив с некорректными данными");
        try {
            int result = sumStringArray4x4(wrongDataArray);
            System.out.println("Сумма: " + result);
        }catch (MyArrayDataException | MyArraySizeException e){
            System.out.println("Ошибка: " + e.getMessage());
        }


    }
    public static int sumStringArray4x4 (String[][] array) throws MyArraySizeException, MyArrayDataException{
        if (array.length != 4){
            throw new MyArraySizeException("Длина массива должна быть равна 4!");
        }
        for (int i=0;i<array.length; i++){
            if (array[i].length != 4){
                throw new MyArraySizeException("Количество столбцов должно быть равно 4!");
            }
        }
        int sum = 0;
        for (int i = 0; i<array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                try{
                    sum += Integer.parseInt(array[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException(i,j, array[i][j]);
                }
            }
        }
        return sum;
    }

}
class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}
class MyArrayDataException extends Exception {
    private int row;
    private int col;
    private String value;

    public MyArrayDataException(int row, int col, String value) {
        super(String.format("Неверные данные в ячейке [%d][%d]: значение %s", row, col, value));
        this.row = row;
        this.col = col;
        this.value = value;

    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public String getValue() {
        return value;
    }

}





