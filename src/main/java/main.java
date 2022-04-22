import java.util.Iterator;

public class main {
    public static void main(String[] args) {
        Doppelt_verkettete_Liste list = new Doppelt_verkettete_Liste();
        list.insert(3);
        list.insert(4);
        list.delete(3);

        Iterator<Integer> it = list.iterator();
        System.out.println(it.next());
    }
}
