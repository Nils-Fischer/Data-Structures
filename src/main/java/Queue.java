import java.util.Iterator;

public class Queue implements Abstract_Queue {
    Node first;
    Node last;

    static class Node{
        int data;
        Node next;
        Node prev;


        Node(int data){
            this.data = data;
        }
        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public void enqueue(int data) {
        if (last == null) first = last = new Node(data);
        else {
            last.prev = new Node(data, last);
            last = last.prev;
        }
    }

    @Override
    public int dequeue(){
        if (last == null) {
            System.out.println("Queue empty");
            return -1;
        }
        int value = first.data;
        if (last != first) {
            first = first.prev;
            first.next = null;
        }
        else last = first = null;
        return value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private Node current = null;

            @Override
            public boolean hasNext() {
                if (current == null)  return first != null;
                return current != last;
            }

            @Override
            public Integer next() {
                if (current == null) current = first;
                else current = current.next;
                return current.data;
            }
        };
    }
}
