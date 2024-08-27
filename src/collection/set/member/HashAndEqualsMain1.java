package collection.set.member;

import collection.set.MyHashSetV2;

public class HashAndEqualsMain1 {

    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);
        MemberOnlyHahs m1 = new MemberOnlyHahs("A");
        MemberOnlyHahs m2 = new MemberOnlyHahs("A");

        System.out.println("m1.hashCode() = " + m1.hashCode());
        System.out.println("m2.hashCode() = " + m2.hashCode());
        System.out.println("m1.equals(m2) = " + m1.equals(m2));

        set.add(m1);
        set.add(m2);

        System.out.println(set);

        MemberOnlyHahs searchValue = new MemberOnlyHahs("A");
        System.out.println("searchValue.hashCode() = " + searchValue.hashCode());

        boolean result = set.contains(searchValue);
        System.out.println("result = " + result);
    }
}
