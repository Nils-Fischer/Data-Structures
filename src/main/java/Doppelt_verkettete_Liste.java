import java.util.Iterator;

public class Doppelt_verkettete_Liste implements Abstract_Doppelt_verkettete_Liste{
    Node head;  // Erstes Element der Liste
    Node tail;  // Letztes Element der Liste

    class Node {
        int data;
        Node next = null;  // nächstes Element
        Node prev = null;  // voriges Element

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
        if (head == null) {  // falls die Liste leer ist:
            head = new Node(data);  // head wird initialisiert
            tail = head;  // head ist gleichzeitig tail, da es nur ein Element gibt
        }
        else {
            tail.next = new Node(data, tail);  // Neues Element wird erstellt und als Nachfolger von tail deklariert
            tail = tail.next;  // tail wird auf das neue Element gesetzt, da es jetzt das letzte ist
        }
    }

    public void delete(int data){
        if (head == null) return;  // falls die Liste leer ist, wird abgebrochen
        if (head.data == data) {  // falls das erste Element der Liste gelöscht werden soll:
            if (head == tail) head = tail = null;  // falls es das einzige Element der Liste ist, wird die Liste geleert
            else {
                head = head.next;  // Der Nachfolger vom head wird als neuer head deklariert
                head.prev = null;  // Referenz auf den vorigen head (zu löschendes Element) wird gelöscht
            }
        }
        else {  // falls das zu löschende Element nicht das erste ist:
            Node current = head;  // Pointer zum head
            while (current.next != null && current.data != data) current = current.next;
           // Pointer durchgeht die Liste bis zum gesuchten Element oder Ende
            if (current.data == data) {  // falls das Element gefunden wurde:
                current.prev.next = current.next;  // Vorgänger ändert seine Referenz, überspringt zu löschendes Element
                if (current.next != null) current.next.prev = current.prev;
                // Nachfolger ändert ebenfalls seine Referenz, zu Vorgänger des zu löschendem Elements
            }
        }
    }


    public Iterator<Integer> iterator(){
        return new Iterator<>() {
            private Node current = null;  // Pointer um aktuelles Element zu erfassen

            @Override
            public boolean hasNext() {
                if (current == null) return head != null;
                // falls current noch nicht initialisiert wurde, wird zurückgegeben, ob die Liste leer ist oder nicht
                return current.next != null;  // Es wird zurückgegeben, ob ein Nachfolger vom aktuellen Elem. existiert
            }

            @Override
            public Integer next() {
                if (current == null) current = head; // falls current noch nicht initialisiert wurde, wird zurückgegeben, ob die Liste leer ist oder nichtelse current = current.next;  // sonst wird current auf das folgende Element gesetzt
                else current = current.next;  // sonst wird current auf den Nachfolger gesetzt
                return current.data;  // Inhalt des aktuellen Iters wird zurückgegeben
            }
        };
    }
}



