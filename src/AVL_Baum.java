import java.util.*;

public class AVL_Baum implements Abstract_AVL_Baum { //Implementierung der Klasse AVL_Baum, implementiert die Methoden des Interfaces


    class Node {	//Implementierung der Klasse Node
        int key, height;
        Node left, right;


        Node(int d) {	//Konstruktor mit allen Variablen
            key = d;
            height = 1;
        }

        public int getKey() {
            return key;
        }

    }
    Node root;

    @Override
    public int compare(Node o1, Node o2) {
        if(o1.getKey() < o2.getKey()){
            return -1;
        }
        else if(o1.getKey() > o2.getKey()){
            return 1;
        }
        else {
            return 0;
        }
    }


    public int height(Node N) {	//Methode um Tiefe eines Knotens auszugeben
        if (N == null){
            return 0;
        }
        return N.height;
    }

    public int max(int a, int b) {	//Methode zum ermitteln des Maximums zweier Integer
        return (a > b) ? a : b;
    }

    public Node rightRotate(Node y) {	//Methode zum Rotieren eines Subtrees nach rechts
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return x;
    }

    public Node leftRotate(Node x) {	//Methode zum Rotieren eines Subtrees nach links
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return y;
    }

    public int getBalance(Node N) {	//Methode zum Ermitteln des Balancefaktors eines Knotens
        if (N == null){
            return 0;
        }
        return height(N.left) - height(N.right);
    }

    public void insert(int value){
        insert(root, value);
    }

    private Node insert(Node node, int key) {	//Methode zum Einfügen eines Knotens in den Baum
        if (node == null){
            return (new Node(key));
        }

        if (key < node.key){
            node.left = insert(node.left, key);
        }
        else if (key > node.key){
            node.right = insert(node.right, key);
        }
        else {
            return node;
        }						//Bis hierhin BST Insertion
        node.height = 1 + max(height(node.left),	//Updated die Tiefe des Knotens
                height(node.right));

        int balance = getBalance(node);		//Überprüft Balancefaktor

        if (balance > 1 && key < node.left.key){
            return rightRotate(node);
        }

        if (balance < -1 && key > node.right.key){
            return leftRotate(node);
        }

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void preOrder(Node node) {	//Methode zum Erstellen eines Arrays zur Representation des Baums in In-Order Struktur
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AVL_Baum tree = new AVL_Baum();

        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(100);
        list.add(1);
        list.add(1000);

        ElementComparator comparator = new ElementComparator();
        Collections.sort(list, comparator);


        tree.root = tree.insert(tree.root, list.get(0));
        tree.root = tree.insert(tree.root, list.get(1));
        tree.root = tree.insert(tree.root, list.get(2));
        tree.root = tree.insert(tree.root, list.get(3));


    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return null;
            }
        };
    }
}

