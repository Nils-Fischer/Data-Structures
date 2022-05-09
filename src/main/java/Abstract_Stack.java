import java.util.Iterator;

public interface Abstract_Stack extends Iterable<Integer>{
    boolean empty();  // überprüft ob der Stack leer ist
    int peek();  // schaut sich das oberste Item im Stack an, ohne es zu entfernen
    int pop();  // entfernt das oberste Item und gibt es zurück
    void push(int data);  // fügt ein Item zum Stack hinzu
    int search(int data);  // sucht nach einem Item im Stack und gibt seine Position, von oben, zurück
    Iterator<Integer> iterator();  // Iterator
}
