import org.junit.jupiter.api.Test;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;

public class BinaerBaum_UnitTest {
    private final binaer_Suchbaum tree = new binaer_Suchbaum();
    private final Iterator<Integer> it = tree.iterator();

    @Test
    void standardTesting(){
        assertFalse(it.hasNext());
        tree.add(5);
        assertTrue(it.hasNext());
        assertEquals(it.next(), 5);
        assertTrue(tree.containsNode(5));
        tree.delete(5);
        assertFalse(tree.containsNode(5));
    }



}
