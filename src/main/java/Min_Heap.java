import java.util.Iterator;

public class Min_Heap implements Abstract_Min_Heap {

    private int[] Heap;
    private int size;
    private int maxsize;
    private static final int FRONT = 1;

    public Min_Heap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
    }

    public int parent(int pos) {
        return pos / 2;
    }

    public int left(int pos) {
        return (2 * pos);
    }

    public int right(int pos) {
        return (2 * pos) + 1;
    }

    public boolean isleaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        else {
            return false;
        }
    }

    public void insert(int element) {
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

    private void swap(int fpos, int spos)
    {

        int tmp;
        tmp = Heap[fpos];

        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public static void main(String[] arg) {
        Min_Heap minHeap = new Min_Heap(15);

        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        minHeap.print();
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}