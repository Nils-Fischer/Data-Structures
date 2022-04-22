import java.util.Iterator;

public interface Abstract_Stack extends Iterable<Integer>{
    boolean empty();
    int peek();
    int pop();
    void push(int data);
    int search(int data);
    Iterator<Integer> iterator();
}
