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

public class Binär_Suchbaum implements Abstract_Binär_Suchbaum{	//Implementierung der Klasse Binär_Suchbaum, implementiert alle Methoden des Interfaces
    Node root;

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

    private Binär_Suchbaum createBinaryTree() {		//Konstruktor mit Testwerten
        Binär_Suchbaum bt = new Binär_Suchbaum();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        return bt;
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
}
