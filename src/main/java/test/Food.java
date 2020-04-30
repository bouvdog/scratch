package test;

class Food {

}

class FastFood extends Food {

}

class Fruit extends Food {

}

class FoodFactory extends Food {

    Food getFood(String type) {
        Food f = null;
        if (type.equals("Fruit")) {
            f = new Fruit();
        } else if (type.equals("FastFood")) {
            f = new FastFood();
        }
        return f;
    }
}

class Solution {
    public static void main(String[] args) {
        FoodFactory myFoods = new FoodFactory();
        Food food1 = myFoods.getFood("FastFood");
        Food food2 = myFoods.getFood("Fruit");
        System.out.println("My name is: " + food1.getClass().getName());
        System.out.println("My name is: " + food2.getClass().getName());
        System.out.println("Our superclass is: "
                + food1.getClass().getSuperclass().getName());
        //food1.serveFood();
        //food2.serveFood();
    }
}