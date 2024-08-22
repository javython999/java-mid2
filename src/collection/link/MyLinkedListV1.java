package collection.link;

public class MyLinkedListV1 {

    private Node node;
    private int size = 0;

    public void add(Object e) {
        Node newNode = new Node(e);
        if (node == null) {
            node = newNode;
        } else {
            Node lastNode = getLastNode();
            lastNode.next = newNode;
        }

        size++;
    }

    private Node getLastNode() {
        Node x = node;

        while (x.next != null) {
            x = x.next;
        }
        return x;
    }

    public Object set(int index, Object e) {
        Node x = getNode(index);
        Object oldValue = x.item;
        x.item = e;
        return oldValue;
    }

    public Object get(int index) {
        Node node = getNode(index);
        return node.item;
    }

    private Node getNode(int index) {
        Node x = node;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public int indexOf(Object e) {
        int index = 0;
        for (Node x = node; x != null; x = x.next) {
            if (x.item.equals(e)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyLinkedListV1{" +
                "node=" + node +
                ", size=" + size +
                '}';
    }
}
