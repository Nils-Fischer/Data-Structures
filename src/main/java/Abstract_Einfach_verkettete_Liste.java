import java.util.Iterator;

public interface Abstract_Einfach_verkettete_Liste extends Iterable<Integer> {
    void delete(int data);
    void insert(int data);
    Iterator<Integer> iterator();
}
