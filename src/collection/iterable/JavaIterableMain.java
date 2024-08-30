package collection.iterable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JavaIterableMain {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> listIter = list.iterator();
        printAll(listIter);
        foreach(list);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        Iterator<Integer> setIter = set.iterator();
        printAll(setIter);
        foreach(set);
    }

    private static void printAll(Iterator<Integer> iterator) {
        System.out.println(iterator.getClass());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void foreach(Iterable<Integer> iterable) {
        System.out.println(iterable.getClass());
        for (Integer integer : iterable) {
            System.out.println(integer);
        }
    }
}
