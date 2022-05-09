import java.util.Iterator;

public interface Abstract_Binaer_Suchbaum extends Iterable<Integer> {
    public void add(int value);
    public boolean containsNode(int value);
    public binaer_Suchbaum.Node delete(int value);
    Iterator<Integer> iterator();
}
