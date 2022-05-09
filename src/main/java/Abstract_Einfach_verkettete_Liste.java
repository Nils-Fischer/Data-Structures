import java.util.Iterator;

public interface Abstract_Einfach_verkettete_Liste extends Iterable<Integer> {
    void delete(int data);  // ein neues Node wird eingefügt
    void insert(int data);  // ein Node mit vorgegebenem Wert wird gelöscht
    Iterator<Integer> iterator();  // Iterator
}
