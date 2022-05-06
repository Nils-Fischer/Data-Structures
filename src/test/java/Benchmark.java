import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class Benchmark {
    private static int runs = 100;

    public static void main(String[] args) {
        ArrayList<Integer> deleteOrder = new ArrayList<>();
        for (int i = 0; i < runs; i++) deleteOrder.add(i);
        Collections.shuffle(deleteOrder);

        int[] runtime_EVList = runtime_EinfachVerketteteListe(deleteOrder);
        int[] runtime_DVList = runtime_DoppeltVerketteteListe(deleteOrder);
        int[] runtime_JList = runtime_list(deleteOrder);
        int[] runtime_Queue = runtime_Queue();
        int[] runtime_JQueue = runtime_JavaQueue();
        int[] runtime_Stack = runtime_Stack();
        int[] runtime_JStack = runtime_JavaStack();

        System.out.printf("Einfache Liste:\tinsert: %d | delete: %d\n", runtime_EVList[0], runtime_EVList[1]);
        System.out.printf("Doppelte Liste:\tinsert: %d | delete: %d\n", runtime_DVList[0], runtime_DVList[1]);
        System.out.printf("Java List:\tinsert: %d | delete: %d\n", runtime_JList[0], runtime_JList[1]);
        System.out.printf("Queue:\tinsert: %d | delete: %d\n", runtime_Queue[0], runtime_Queue[1]);
        System.out.printf("Java Queue:\tinsert: %d | delete: %d\n", runtime_JQueue[0], runtime_JQueue[1]);
        System.out.printf("Stack:\tinsert: %d | delete: %d\n", runtime_Stack[0], runtime_Stack[1]);
        System.out.printf("Java Stack:\tinsert: %d | delete: %d\n", runtime_JStack[0], runtime_JStack[1]);
    }

    private static int[] runtime_EinfachVerketteteListe(ArrayList<Integer> deleteItems) {

        Einfach_Verkettete_Liste list = new Einfach_Verkettete_Liste();
        ArrayList<Integer> deleteOrder = new ArrayList<>(deleteItems);
        long runtime_insert= 0;
        long runtime_delete = 0;

        for (int i = 0; i < runs; i++) {
            long start = System.nanoTime();
            list.insert(i);
            runtime_insert += (System.nanoTime() - start) / runs;
        }
        for (int i = 0; i < runs; i++) {
            int temp = deleteOrder.remove(0);
            long start = System.nanoTime();
            list.delete(temp);
            runtime_delete += (System.nanoTime() - start) / runs;
        }
        return new int[]{(int) runtime_insert, (int) runtime_delete};
    }

    private static int[] runtime_DoppeltVerketteteListe(ArrayList<Integer> deleteItems) {
        Einfach_Verkettete_Liste list = new Einfach_Verkettete_Liste();
        ArrayList<Integer> deleteOrder = new ArrayList<>(deleteItems);
        long runtime_insert= 0;
        long runtime_delete = 0;

        for (int i = 0; i < runs; i++) {
            long start = System.nanoTime();
            list.insert(i);
            runtime_insert += (System.nanoTime() - start) / runs;
        }
        for (int i = 0; i < runs; i++) {
            int temp = deleteOrder.remove(0);
            long start = System.nanoTime();
            list.delete(temp);
            runtime_delete += (System.nanoTime() - start) / runs;
        }
        return new int[]{(int) runtime_insert, (int) runtime_delete};
    }

    private static int[] runtime_list(ArrayList<Integer> deleteOrder) {
        LinkedList<Integer> list = new LinkedList<>();
        long runtime_insert= 0;
        long runtime_delete = 0;

        for (int i = 0; i < runs; i++) {
            long start = System.nanoTime();
            list.add(i);
            runtime_insert += (System.nanoTime() - start) / runs;
        }
        for (int i = 0; i < runs; i++) {
            int temp = deleteOrder.remove(0);
            long start = System.nanoTime();
            list.removeFirstOccurrence(temp);
            runtime_delete += (System.nanoTime() - start) / runs;
        }
        return new int[]{(int) runtime_insert, (int) runtime_delete};
    }

    private static int[] runtime_Queue(){
        Queue queue = new Queue();
        long runtime_enqueue = 0;
        long runtime_dequeue = 0;

        for (int i = 0; i < runs; i++){
            long start = System.nanoTime();
            queue.enqueue(i);
            runtime_enqueue += (System.nanoTime() - start) / runs;

            start = System.nanoTime();
            queue.dequeue();
            runtime_dequeue += (System.nanoTime() - start) / runs;
        }
        return new int[]{(int) runtime_enqueue, (int) runtime_dequeue};
    }

    private static int[] runtime_JavaQueue(){
        java.util.Queue<Integer> queue = new LinkedList<>();
        long runtime_enqueue = 0;
        long runtime_dequeue = 0;

        for (int i = 0; i < runs; i++){
            long start = System.nanoTime();
            queue.offer(i);
            runtime_enqueue += (System.nanoTime() - start) / runs;

            start = System.nanoTime();
            queue.poll();
            runtime_dequeue += (System.nanoTime() - start) / runs;
        }
        return new int[]{(int) runtime_enqueue, (int) runtime_dequeue};
    }

    private static int[] runtime_Stack(){
        Stack stack = new Stack();
        long runtime_push = 0;
        long runtime_pop = 0;
        
        for (int i = 0; i < runs; i++){
           long start = System.nanoTime();
           stack.push(i);
           runtime_push += (System.nanoTime() - start) / runs;
           
           start = System.nanoTime();
           stack.pop();
           runtime_pop += (System.nanoTime() - start) / runs;
        }
        return new int[]{(int) runtime_push, (int) runtime_pop};
    }

    private static int[] runtime_JavaStack(){
        Stack<Integer> stack = new Stack<>();
        long runtime_push = 0;
        long runtime_pop = 0;

        for (int i = 0; i < runs; i++){
            long start = System.nanoTime();
            stack.push(i);
            runtime_push += (System.nanoTime() - start) / runs;

            start = System.nanoTime();
            stack.pop();
            runtime_pop += (System.nanoTime() - start) / runs;
        }
        return new int[]{(int) runtime_push, (int) runtime_pop};
    }
}
