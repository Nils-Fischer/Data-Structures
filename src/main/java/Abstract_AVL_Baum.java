public interface Abstract_AVL_Baum {
    int height(AVL_Baum.Node N);
    int max(int a, int b);
    AVL_Baum.Node rightRotate(AVL_Baum.Node y);
    AVL_Baum.Node leftRotate(AVL_Baum.Node x);
    int getBalance(AVL_Baum.Node N);
    AVL_Baum.Node insert(AVL_Baum.Node node, int key);
    void preOrder(AVL_Baum.Node node);
}
