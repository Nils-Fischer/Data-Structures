import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Iterator;

public class doubleLinkedList_UnitTest {
    private final Doppelt_verkettete_Liste list = new Doppelt_verkettete_Liste();
    private final Iterator<Integer> it = list.iterator();

    @Test
    void standardTesting() {
        assertFalse(it.hasNext());
        list.insert(5);
        assertTrue(it.hasNext());
        assertEquals(it.next(), 5);
        list.delete(5);
        assertFalse(it.hasNext());
    }
}
