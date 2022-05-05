import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Iterator;

public class MinHeap_UnitTest {
    private final Min_Heap heap = new Min_Heap(2);
    private final Iterator<Integer> it = heap.iterator();

    @Test
    void standardTesting() {
        assertFalse(it.hasNext());
        heap.insert(5);
        assertTrue(it.hasNext());
        assertEquals(it.next(), 5);
        assertFalse(it.hasNext());
    }
}
