package org.example;

//Again, might be stupidly overcomplecated, but it works (usually) and i mostly of understand what is going on, at least at the time of writing

// Abstract base class representing an animal
abstract class Animal {
    String type;        // Type of animal (e.g., "Mammal", "Fish", "Bird")
    String breed;       // Breed of the animal (e.g., "Calico", "Ragdoll")
    String name;        // Animal name
    String color;       // Animal color
    byte numLegs;       // Number of legs the animal has
    String favoriteFood; // Animal's favorite food

    // Initialize animal properties
    public Animal(String type, String breed, String name, String color, byte numLegs, String favoriteFood) {
        this.type = type;
        this.breed = breed;
        this.name = name;
        this.color = color;
        //For each subclass, when it says byte(#) that is the number of legs the animal has. I want it to look prettier in the code, but I am too worn out at this point.
        this.numLegs = numLegs;
        this.favoriteFood = favoriteFood;
    }

    // Abstract method for having the animal make sound with each child class's version of it
    abstract void makeSound();

    // Method to make animal eat
    void eat(String food) {
        System.out.println(name + " is eating their favorite food, " + food);
    }

    // Method to make animal sleep
    void sleep() {
        System.out.println(name + " is sleeping. Zzzzzzzzzzzzz!");
    }
}

// Cat child class
class Cat extends Animal {
    public Cat(String breed, String name, String color, String favoriteFood) {
        super("Mammal", breed, name, color, (byte) 4, favoriteFood);
    }

    void makeSound() {
        System.out.println(name + " says meow!");
    }
}

// Dog child class
class Dog extends Animal {
    public Dog(String breed, String name, String color, String favoriteFood) {
        super("Mammal", breed, name, color, (byte) 4, favoriteFood);
    }

    void makeSound() {
        System.out.println(name + " says woof!");
    }
}

// Fish child class
class Fish extends Animal {
    public Fish(String breed, String name, String color, String favoriteFood) {
        super("Fish", breed, name, color, (byte) 0, favoriteFood);
    }

    void makeSound() {
        System.out.println(name + " says blub blub!");
    }
}

// Bird child class
class Bird extends Animal {
    public Bird(String breed, String name, String color, String favoriteFood) {
        super("Bird", breed, name, color, (byte) 2, favoriteFood);
    }

    void makeSound() {
        System.out.println(name + " says chirp chirp!");
    }
}

public class Main {
    public static void main(String[] args) {
        // Data for initializing each instance of pet
        String[][] petData = {
                {"Calico", "Penny", "Orange", "Tuna"},
                {"Ragdoll", "Willow", "White", "Salmon"},
                {"Doodle", "Millie", "Black", "Meat"},
                {"Parrot", "Polly", "Green", "Crackers"},
                {"Blue jay", "Mordecai", "Blue", "A grilled cheese deluxe from Cheesers"},
                {"Goldfish", "Sir Francis IV", "Orange", "Fish Food"}
        };

        // Make an array of 6
        Animal[] animals = new Animal[6];

        // Wizard magic for initializing data from above into the array
        animals[0] = new Cat(petData[0][0], petData[0][1], petData[0][2], petData[0][3]);
        animals[1] = new Cat(petData[1][0], petData[1][1], petData[1][2], petData[1][3]);
        animals[2] = new Dog(petData[2][0], petData[2][1], petData[2][2], petData[2][3]);
        animals[3] = new Bird(petData[3][0], petData[3][1], petData[3][2], petData[3][3]);
        animals[4] = new Bird(petData[4][0], petData[4][1], petData[4][2], petData[4][3]);
        animals[5] = new Fish(petData[5][0], petData[5][1], petData[5][2], petData[5][3]);

        // What the user sees in the command line
        for (Animal animal : animals) {
            animal.makeSound();
            animal.eat(animal.favoriteFood);
            animal.sleep();
            System.out.println();
        }
    }
}
