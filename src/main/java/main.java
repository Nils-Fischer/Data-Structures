import java.util.Iterator;

public class main {
    public static void main(String[] args) {
        Einfach_Verkettete_Liste list = new Einfach_Verkettete_Liste();
        list.insert(3);
        list.insert(4);
        list.delete(4);

        Iterator<Integer> it = list.iterator();
        System.out.println(it.next());
    }
}
