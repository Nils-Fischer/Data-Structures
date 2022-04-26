public interface Abstract_AVL_Baum {
    int height(Node N);
    int max(int a, int b);
    Node rightRotate(Node y);
    Node leftRotate(Node x);
    int getBalance(Node N);
    Node insert(Node node, int key);
    void preOrder(Node node);
}
