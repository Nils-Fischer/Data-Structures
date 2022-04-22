import java.util.Iterator;

class Einfach_Verkettete_Liste implements Abstract_Einfach_verkettete_Liste {
    Node head;  // Erstes Element der Liste

    static class Node{
        int data;
        Node next = null;  // nächstes Element

        Node(int data){
            this.data = data;
        }

        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    public void insert(int data){
        if (head == null) head = new Node(data); // head wird initialisiert, falls noch nicht geschehen
        else {
            Node current = head; // current Node wird auf head gesetzt
            while (current.next != null) current = current.next;  // es wird zum letzten Element der Liste gegangen
            current.next = new Node(data);  // neues Node wird angehangen
        }
    }

    public void delete(int data){
        if (head == null) return;  // falls Liste leer ist, wird der Prozess abgebrochen
        if (head.data == data) head = head.next;
        // falls der head gelöscht werden soll, reicht es den Nachfolger als head zu erklären
        else {  // Wenn nicht der head gelöscht werden soll
            Node current = head;  // pointer zum durchgehen der Liste wird auf head gesetzt
            while (current.next != null && current.next.data != data) current = current.next;
            // Liste wird durchgangen bis zum Vorgänger des gesuchten Elementes, oder das Ende erreicht wurde
            if (current.next != null) current.next = current.next.next;
            // Wenn das Element gefunden wurde, wird das zu löschende Elemente in der Referenz übersprungen
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>(){
            private Node current = null;  // Pointer um aktuelles Element zu erfassen

            @Override
            public boolean hasNext(){
                if (current == null) return head != null;  // falls Liste leer ist, wird false zurückgegeben, sonst true
                return current.next != null;  // Es wird zurückgegeben, ob ein Nachfolger vom aktuellen Elem. existiert
            }

            @Override
            public Integer next() {
                if (current == null) current = head;  // falls noch nicht geschehen, wird current mit head initialisiert
                else current = current.next;  // sonst wird current auf das folgende Element gesetzt
                return current.data;  // Inhalt des aktuellen Iters wird zurückgegeben
            }
        };
    }
}
