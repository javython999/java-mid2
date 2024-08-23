package collection.link;

public class MyLInkedListV3Main {

    public static void main(String[] args) {
        MyLinkedListV3<String> stringList = new MyLinkedListV3<>();

        // 마지막 추가 O(n)
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        // list.add(1); 컴파일 에러
        String string = stringList.get(0);
        System.out.println("string = " + string);

        MyLinkedListV3<Integer> integerList = new MyLinkedListV3<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        // integerList.add("4"); 컴파일 에러
        Integer integer = integerList.get(0);
        System.out.println("integer = " + integer);


    }
}
