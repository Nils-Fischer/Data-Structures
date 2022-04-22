import java.util.Iterator;

public interface Abstract_Doppelt_verkettete_Liste extends Iterable<Integer> {
    void insert(int data);
    void delete(int data);
    Iterator<Integer> iterator();
}

