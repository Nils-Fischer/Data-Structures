import java.util.Iterator;

public interface Abstract_Min_Heap extends Iterable<Integer> {
    int parent(int pos);
    int left(int pos);
    int right(int pos);
    boolean isleaf(int pos);
    void insert(int element);
    void print();
    Iterator<Integer> iterator();
}