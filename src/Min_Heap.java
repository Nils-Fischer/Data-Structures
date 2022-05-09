import java.util.Iterator;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Min_Heap implements Abstract_Min_Heap {	//Implementierung der Klasse Min_Heap, implementiert alle Methoden des Interfaces

    private int[] Heap;
    private int size;
    private int maxsize;
    private static final int FRONT = 1;

    public Min_Heap(int maxsize) {	//Konstruktor
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
    }

    public int parent(int pos) {	//Methode um die Position des Eltern-Knotens des aktuellen Knotens zu ermitteln
        return pos / 2;
    }

    public int left(int pos) {		//Methode um die Position des linken Tochter-Knotens des aktuellen Knotens zu ermitteln
        return (2 * pos);
    }

    public int right(int pos) {		//Methode um die Position des rechten Tochter-Knotens des aktuellen Knotens zu ermitteln
        return (2 * pos) + 1;
    }

    public boolean isleaf(int pos) {		//Methode zum überprüfen, ob der aktuelle Knoten ein Leaf ist
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        else {
            return false;
        }
    }

    public void insert(int element) {		//Methode zum einfügen eines Knotens
        if (size >= maxsize) {
            return;
        }
        Heap[++size] = element;
        int current = size;
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private void swap(int fpos, int spos)	//Methode zum tauschen zweier Knoten
    {

        int tmp;
        tmp = Heap[fpos];

        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    public void print() {		//Methode zum printen des Heaps
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public static void main(String[] arg) {	//Main-Method mit Testwerten
        Min_Heap minHeap = new Min_Heap(15);

        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(100);
        list.add(1);
        list.add(1000);

        ElementComparator comparator = new ElementComparator();
        Collections.sort(list, comparator);


        minHeap.insert(list.get(0));
        minHeap.insert(list.get(1));
        minHeap.insert(list.get(2));
        minHeap.insert(list.get(3));
        minHeap.print();
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
