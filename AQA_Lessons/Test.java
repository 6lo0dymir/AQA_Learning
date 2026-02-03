public class Test {
    public static void main(String[] args) {
        Bowl catBowl = new Bowl(40);

        Cat[] cats = {
                new Cat("Барсик"),
                new Cat("Мурзик"),
                new Cat("Гав"),
                new Cat("Леопольд"),
                new Cat("Том")
        };
        for (int i = 0; i < cats.length; i++){
            Cat cat = cats[i];
            cat.feedTheCat(catBowl,10);
        }

    }
}
