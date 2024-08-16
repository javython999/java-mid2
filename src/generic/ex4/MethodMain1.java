package generic.ex4;

public class MethodMain1 {

    public static void main(String[] args) {
        Integer i = 10;

        Object object = GenericMethod.objMethod(i);
        
        // 타입인자(Type Argument) 명시적 전달
        Integer result = GenericMethod.<Integer>genericMethod(i);
        System.out.println("result: " + result);

        Integer integerValue = GenericMethod.numberMethod(10);
        Double doubleValue = GenericMethod.<Double>numberMethod(20.0);

    }
}
