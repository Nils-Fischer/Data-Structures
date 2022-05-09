import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Iterator;

public class Queue_UnitTest {
    private final Queue queue= new Queue();
    private final Iterator<Integer> it = queue.iterator();

    @Test
    void standardTesting() {
       assertFalse(it.hasNext());
       queue.enqueue(4);
       assertTrue(it.hasNext());
       assertEquals(4, queue.dequeue());
    }

    @Test
    void exceptionTesting() {
        Exception exception = assertThrows(
                IndexOutOfBoundsException.class,
                queue::dequeue
        );
        assertEquals("Queue ist leer", exception.getMessage());
    }
}
