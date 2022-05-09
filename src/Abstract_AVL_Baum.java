import java.util.Comparator;
import java.util.Iterator;

public interface Abstract_AVL_Baum extends Iterable<Integer>, Comparator<AVL_Baum.Node> {

    int compare(AVL_Baum.Node o1, AVL_Baum.Node o2);

    int height(AVL_Baum.Node N);
    int max(int a, int b);
    AVL_Baum.Node rightRotate(AVL_Baum.Node y);
    AVL_Baum.Node leftRotate(AVL_Baum.Node x);
    int getBalance(AVL_Baum.Node N);
    void insert(int key);
    void preOrder(AVL_Baum.Node node);
    Iterator<Integer> iterator();

}
