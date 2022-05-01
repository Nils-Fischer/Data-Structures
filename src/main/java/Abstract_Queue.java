import java.util.Iterator;

public interface Abstract_Queue extends Iterable<Integer> {
    void enqueue(int data);
    int dequeue();
    Iterator<Integer> iterator();
}
