public class CompareNumbers {
    public static void main(String[] args) {
        System.out.println(isEqual(1,1));
        System.out.println(notEqual(1,2));
        System.out.println(isGreater(2,1));


    }

    public static boolean isEqual (int a, int b){
        return a == b;
    }
    public static boolean notEqual (int a, int b){
        return a != b;
    }
    public static boolean isGreater (int a, int b){
        return a > b;
    }
    public static boolean isGreaterOrEqual (int a, int b){
        return a>=b;
    }
    public static boolean isLesser (int a, int b){
        return a<b;
    }
    public static boolean isLesserOrEqual (int a, int b){
        return a<=b;
    }
    public static int getMax (int a, int b){
        return Math.max(a,b);
    }
    public static int getMin (int a, int b){
        return Math.min(a,b);
    }

}
