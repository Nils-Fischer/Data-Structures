import java.util.Iterator;

public interface Abstract_Binaer_Suchbaum extends Iterable<Integer> {
    void add(int value);
    boolean containsNode(int value);
    binaer_Suchbaum.Node delete(int value);
    Iterator<Integer> iterator();
}
