package collection.link;

import javax.print.DocFlavor;

public class NodeMain3 {

    public static void main(String[] args) {

        Node first = new Node("A");
        Node second = new Node("B");
        Node third = new Node("C");

        first.next = second;
        first.next.next = third;

        System.out.println(first);

        // 모든 노드 탐색
        System.out.println("모든 노드 탐색");
        printAll(first);

        // 마지막 노드 조회
        Node lastNode = getLastNode(first);
        System.out.println("lastNode = " + lastNode);

        // 특정 index의 노드 조회
        int index = 2;
        Node index2Node = getNode(first, index);
        System.out.println("index2Node = " + index2Node.item);

        // 데이터 추가
        System.out.println("데이터 추가");
        add(first, "D");
        add(first, "E");
        add(first, "F");
        System.out.println(first);

    }

    private static void printAll(Node node) {
        Node x = node;

        while (x.next != null) {
            System.out.println(x.item);
            x = x.next;
        }
    }

    private static Node getLastNode(Node node) {
        Node x = node;

        while (x.next != null) {
            x = x.next;
        }

        return x;
    }

    private static Node getNode(Node node, int index) {
        Node x = node;

        for (int i = 0; i < index; i++) {
            x = x.next;
        }

        return x;
    }

    private static void add(Node node, String data) {
        getLastNode(node).next = new Node(data);
    }
}
