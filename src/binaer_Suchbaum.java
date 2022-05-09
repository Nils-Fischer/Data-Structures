import java.util.Iterator;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class binaer_Suchbaum implements Abstract_Binaer_Suchbaum {	//Implementierung der Klasse Binär_Suchbaum, implementiert alle Methoden des Interfaces
    Node root;

    class Node {	//Implementierung der Klasse Node
        int value;
        Node left;
        Node right;

        Node(int value) {	//Konstruktor mit allen Variablen
            this.value = value;
            right = null;
            left = null;
        }
    }
    private Node addRecursive(Node current, int value) {	//Rekursive Implementierung der Add-Methode um einen Knoten hinzu zu fügen
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }

        return current;
    }
    public void add(int value) {	//Public Methode um die Recursive Add-Methode aufrufen zukönnen
        root = addRecursive(root, value);
    }

    public binaer_Suchbaum createBinaryTree() {		//Konstruktor mit Testwerten
        binaer_Suchbaum bt = new binaer_Suchbaum();

        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(100);
        list.add(1);
        list.add(1000);

        ElementComparator comparator = new ElementComparator();
        Collections.sort(list, comparator);


        bt.add(list.get(0));
        bt.add(list.get(1));
        bt.add(list.get(2));
        bt.add(list.get(3));

        return bt;
    }

    public void main(String[] args) {
        createBinaryTree();
    }

    private boolean containsNodeRecursive(Node current, int value) {	//Rekursive implementierung der contains-methode zum überprüfen, ob der Baum einen bestimmten Knoten bereits enthält
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {	//Public Method um die Recursive Contains-Methode aufrufen zukönnen
        return containsNodeRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {	//Rekursive implementierung der delete-Methode zum löschen von Knoten
        if (current == null) {
            return null;
        }

        if (value == current.value) {

        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    public Node delete(int value){	//Public Method um die Rekursive delete Methode aufrufen zu können
        return deleteRecursive(root, value);
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
