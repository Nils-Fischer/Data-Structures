import java.util.Iterator;

public class main {
    public static void main(String[] args) throws Exception {
        Queue q = new Queue();

        Iterator<Integer> it = q.iterator();
        System.out.println(it.hasNext());
    }
}
