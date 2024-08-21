package collection.link;

public class NodeMain2 {

    public static void main(String[] args) {

        Node first = new Node("A");
        Node second = new Node("B");
        Node third = new Node("C");

        first.next = second;
        first.next.next = third;

        System.out.println(first);
    }
}
