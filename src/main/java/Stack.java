import java.util.Iterator;

public class Stack implements  Abstract_Stack{
    Item top;

    class Item{
        int data;
        Item prev;

        Item(int data){
            this.data = data;
        }

        Item(int data, Item prev){
            this.data = data;
            this.prev = prev;
        }
    }

    @Override
    public boolean empty() {
        return top == null; // falls top nicht existiert ist der Stack leer und somit der Rückgabewert false
    }

    @Override
    public int peek() {
        if (empty()) throw new IndexOutOfBoundsException();
        return top.data;  // Wert des obersten Items wird ausgelesen und zurückgegeben
    }

    @Override
    public int pop() {
        if (empty()) throw new IndexOutOfBoundsException();
        int value = top.data;  // Wert des obersten Items wird ausgelesen
        top = top.prev;  // der Vorgänger des obersten Items wird zu top
        return value;
    }

    @Override
    public void push(int data) {
        top = new Item(data, top);  // top wird ersetzt durch ein neues Item
    }

    @Override
    public int search(int data) {
        if (empty()) return -1; // wenn der Stack leer ist, wird direkt -1 zurückgegeben
        Item current = top;  // temporäres Item wird erstellt, um den Stack zu durchgehen
        int counter = 0;  // counter um tiefe des Items zu erfassen
        while (current.data != data){  // alle nicht passende Items im Stack werden durchlaufen
            if (current.prev == null) return -1;  // falls das letzte Element erreicht wurde, wird abgebrochen
            current = current.prev;  // current wird auf den Vorgänger gesetzt
            counter++;  // Counter wird erhöht
        }
        return counter;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private Item current = null;

            @Override
            public boolean hasNext() {
                if (current == null) return top != null;
                // falls current noch nicht gesetzt wurde, wird zurückgegeben ob der Stack leer ist
                return current.prev != null;  // es wird zurückgegeben, ob ein Vorgänger existiert
            }

            @Override
            public Integer next() {
                if (empty()) current = top;  // falls der Stack leer ist, wird current zum obersten Item gesetzt
                else current = current.prev;  // sonst wird current auf den Vorgänger gesetzt
                return current.data;  // Wert von current wird zurückgegeben
            }
        };
    }
}
