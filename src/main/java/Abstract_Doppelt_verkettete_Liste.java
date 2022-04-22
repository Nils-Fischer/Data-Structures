import java.util.Iterator;

public interface Abstract_Doppelt_verkettete_Liste extends Iterable<Integer> {
    void insert(int data);  // ein neues Node wird eingefügt
    void delete(int data);  // ein Node mit vorgegebenem Wert wird gelöscht
    Iterator<Integer> iterator();  // Iterator
}

