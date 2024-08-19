package collection.array;

public class MyArrayListV4Main {

    public static void main(String[] args) {
        MyArrayListV4<String> stringList = new MyArrayListV4<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        // stringList.add(1); 다른 데이터형 add시 컴파일 오류 발생

        String string = stringList.get(0);
        System.out.println("string = " + string);


        MyArrayListV4<Integer> integerList = new MyArrayListV4<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        // integerList.add(1); 다른 데이터형 add시 컴파일 오류 발생

        Integer integer = integerList.get(0);
        System.out.println("integer = " + integer);

    }
}
