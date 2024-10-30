package menu;

import commands.SelectAnimals;
import animal.Animal;
import animal.Cat;
import animal.Dog;
import animal.Duck;

public class addanimal {

    private String name;
    private int age;
    private int weight;
    private String color;

    public addanimal(String name, int age, int weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public Animal createAnimal (SelectAnimals selectAnimals){
        //Animal animal = null;

        switch (selectAnimals){
            case DOG:
                return new Dog(name,age,weight,color);
            case CAT:
                return new Cat(name,age,weight,color);

            case DUCK:
                return new Duck(name,age,weight,color);

        }

        return null;
    }
}
