import java.util.Iterator;

public class Doppelt_verkettete_Liste implements Abstract_Doppelt_verkettete_Liste{
    Node head;
    Node tail;

    class Node {
        int data;
        Node next = null;
        Node prev = null;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node prev) {
            this.data = data;
            this.prev = prev;
        }

        Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public void insert(int data){
        if (head == null) {
            head = new Node(data);
            tail = head;
        }
        else {
            tail.next = new Node(data, tail);
            tail = tail.next;
        }
    }

    public void delete(int data){
        if (head == null) return;
        if (head.data == data) {
            if (head == tail) head = tail = null;
            else {
                head = head.next;
                head.prev = null;
            }
        }
        else {
            Node current = head;
            while (current.next != null && current.data != data) current = current.next;
            if (current.data == data) {
                current.prev.next = current.next;
                if (current.next != null) current.next.prev = current.prev;
            }
        }
    }


    public Iterator<Integer> iterator(){
        return new Iterator<>() {
            private Node current = null;

            @Override
            public boolean hasNext() {
                if (current == null) return head != null;
                return current.next != null;
            }

            @Override
            public Integer next() {
                if (current == null) current = head;
                else current = current.next;
                return current.data;
            }
        };
    }
}



