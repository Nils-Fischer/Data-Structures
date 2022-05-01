import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Iterator;

public class Stack_UnitTest {
    private final Stack stack = new Stack();
    private final Iterator<Integer> it = stack.iterator();

    @Test
    void standardTesting() {
        assertFalse(it.hasNext());
        stack.push(5); stack.push(2); stack.push(3);
        assertTrue(it.hasNext());
        assertEquals(5, stack.peek());
        assertEquals(2, stack.search(3));
        assertEquals(5, stack.pop());
        stack.pop(); stack.pop();
        assertTrue(stack.empty());
    }

    @Test @BeforeAll
    void exceptionTesting() {
        Exception exception = assertThrows(
                IndexOutOfBoundsException.class,
                stack::pop
        );
        assertEquals(new IndexOutOfBoundsException(), exception);
    }
}
