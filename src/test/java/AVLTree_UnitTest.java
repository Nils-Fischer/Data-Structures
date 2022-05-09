import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Iterator;

public class AVLTree_UnitTest {
    private final AVL_Baum tree = new AVL_Baum();
    private final Iterator<Integer> it = tree.iterator();

    @Test
    void standardTesting() {
        assertFalse(it.hasNext());
        tree.insert(5);
        assertTrue(it.hasNext());
        assertEquals(it.next(), 5);
    }
}
