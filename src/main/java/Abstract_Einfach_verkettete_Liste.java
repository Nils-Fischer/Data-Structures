import java.util.Iterator;

public interface Abstract_Einfach_verkettete_Liste{
    public int getData();
    public int setData(int data);
    public void setNextNode();
    public Object getNextNdoe();
    public int search(int data);
    public void push(int data);
    public void delete(int data);
    public void insert(int data);
    public int max();
    public int min();
    public Iterator<String> iterator();
}
