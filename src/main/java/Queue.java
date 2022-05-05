import java.util.Iterator;

public class Queue implements Abstract_Queue {
    Node first;  // vorderstes Element der Queue
    Node last;  // letztes Element der Queue

    static class Node{
        int data;
        Node next;  // nächstes Element
        Node prev;  // voriges Element


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
        if (last == null) first = last = new Node(data);  // falls Liste leer ist, wird die Queue initialisiert
        else {  // falls nicht leer:
            last.prev = new Node(data, last);  // das letzte Element erhält das neue Element als Vorgänger
            last = last.prev;  // last wird auf das neue Element gesetzt
        }
    }

    @Override
    public int dequeue(){
        if (last == null) {  // falls die Queue leer ist:
            throw new IndexOutOfBoundsException("Queue ist leer");
        }
        int value = first.data;  // Inhalt des vordersten Elements wird als value kopiert
        if (last != first) {  // wenn die Queue mehr als ein Element enthält:
            first = first.prev;  //  das 2. vorderste Element wird als first deklariert
            first.next = null; // das 2. vorderste Element löscht seine Referenz auf das vorderste
        }
        else last = first = null; // Wenn sich nur ein Element in der Queue befindet, wird die Liste geleert
        return value;  // value des vordersten Elements wird zurückgegeben
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private Node current = null;  // Pointer zum aktuellen Iter

            @Override
            public boolean hasNext() {
                if (current == null)  return first != null;
                // falls current noch nicht initialisiert wurde, wird zurückgegeben, ob die Liste leer ist oder nicht
                return current != last;  // Es wird zurückgegeben, ob ein Nachfolger vom aktuellen Elem. existiert
            }

            @Override
            public Integer next() {
                if (current == null) current = first;  // wenn noch nicht passiert, wird current initialisert
                else current = current.next;  // sonst wird currrent auf den Nachfolger gesetzt
                return current.data;  // Inhalt des aktuellen Iters wird zurückgegeben
            }
        };
    }
}
