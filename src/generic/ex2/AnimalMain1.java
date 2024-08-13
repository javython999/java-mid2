package generic.ex2;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalMain1 {

    public static void main(String[] args) {

        Animal animal = new Animal("동물", 0);
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("야옹이", 50);

        Box<Dog> dogBox = new Box<>();
        dogBox.set(dog);
        System.out.println(dogBox.get());

        Box<Cat> catBox = new Box<>();
        catBox.set(cat);
        System.out.println(catBox.get());

        Box<Animal> animalBox = new Box<>();
        animalBox.set(animal);
        System.out.println(animalBox.get());


    }


}
