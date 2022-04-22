import java.util.Iterator;

class Einfach_Verkettete_Liste implements Abstract_Einfach_verkettete_Liste {
    Node head;

    class Node{
        int data;
        Node next = null;

        Node(int data){
            this.data = data;
        }

        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    public void insert(int data){
        if (head == null) head = new Node(data); // falls head noch nicht gesetzt wurde
        else {
            Node current = head; // current Node wird auf head gesetzt
            while (current.next != null) current = current.next;  // es wird zum letzten element der Liste gegangen
            current.next = new Node(data);  // neue Node wird angehangen
        }
    }

    public void delete(int data){
        if (head == null) return;
        if (head.data == data) head = head.next; // falls der head gelöscht werden soll, wird einfach der head auf den Nachfolger gelegt
        else {
            Node current = head;
            while (current.next != null && current.next.data != data) current = current.next;
            if (current.next != null) current.next = current.next.next;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>(){
            private Node current = null;

            @Override
            public boolean hasNext(){
                if (current == null) return false;
                return (current.next != null);
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
