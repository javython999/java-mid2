package generic.ex5;

import generic.animal.Cat;
import generic.animal.Dog;

public class WhildcardMain1 {

    public static void main(String[] args) {
        Box<Object> objectBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        dogBox.set(new Dog("멍멍이", 100));

        WhildcardEx.printGenericV1(dogBox);
        WhildcardEx.printWildcard1(dogBox);
        System.out.println("-----".repeat(10));
        WhildcardEx.printGenericV2(dogBox);
        WhildcardEx.printWildcard2(dogBox);
        System.out.println("-----".repeat(10));
        WhildcardEx.printGenericV3(dogBox);
        WhildcardEx.printWildcard3(dogBox);
    }
}
