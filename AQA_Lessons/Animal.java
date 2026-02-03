import javax.swing.*;
import java.security.Principal;

public abstract class Animal {
    protected String name;
    protected static int animalCount = 0;
    public Animal (String name){
        this.name = name;
        animalCount++;
    }

    public abstract void run(int distance);
    public abstract void swim(int distance);

    public static int getAnimalCount(){
        return animalCount;
    }

}

class Dog extends Animal{
    private static int dogCount = 0;
    private final int maxRunDistance = 500;
    private final int maxSwimDistance = 10;

    public Dog (String name){
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance){
        if (distance <= maxRunDistance && distance > 0){
            System.out.println(name + " пробежал " + distance + " метров");
        }else{
            System.out.println(name + " не сможет столько пробежать!");
        }
    }

    @Override
    public void swim(int distance){
        if (distance <= maxSwimDistance && distance > 0){
            System.out.println(name + " проплыл " + distance + " метров");
        }else{
            System.out.println(name + " не сможет столько проплыть!");
        }
    }
    public static int getDogCount(){
        return dogCount;
    }


}
class Cat extends Animal{
    private static int catCount = 0;
    private final int maxRunDistance = 200;
    private boolean isFull = false;

    public Cat (String name){
        super(name);
        catCount++;
    }
    @Override
    public void run(int distance){
        if (distance <= maxRunDistance && distance > 0){
            System.out.println(name + " пробежал " + distance + " метров");
        }else{
            System.out.println(name + " не сможет столько пробежать!");
        }
    }
    @Override
    public void swim(int distance){
        System.out.println(name + " Не умеет плавать!");
    }

    public static int getCatCount(){
        return catCount;
    //Работа с сытостью//
    }
    public boolean isFull(){
        return isFull;
    }
    public void setFull(){
        isFull = true;
    }
    public void feedTheCat (Bowl bowl, int foodAmount){
        if (bowl.decreaseFood(foodAmount)){
            isFull = true;
            System.out.println(name + " поел и теперь сытый!");
        }else{
            System.out.println(name + " не хватило еды он голодный!");
        }
    }

}
//Миска//
class Bowl{
    private int foodAmount;

    public Bowl (int initialFood){
        if (initialFood < 0){
            this.foodAmount = 0;
            System.out.println("В миске не может быть отрицательное число, возвращено на 0!");
        }else{
            this.foodAmount = initialFood;
        }
    }
    public boolean decreaseFood (int amount){
        if (foodAmount >= amount && amount > 0){
            foodAmount = foodAmount-amount;
            //System.out.println("Из миски съели " + amount + " еды осталось " + foodAmount);
            return true;
        }else{
            System.out.println("В миске недостаточно еды!");
            return false;
        }
    }
    public void fillTheBowl (int food){
        foodAmount = foodAmount + food;
        System.out.println("В миску положили " + food + " еды, теперь там " + foodAmount + " еды");
    }
    public void bowlFoodInfo(){
        System.out.println("В миске " + foodAmount + " еды");
    }

}