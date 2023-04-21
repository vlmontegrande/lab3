import static org.junit.Assert.*;
import org.junit.*;

public class LinkedListTests {
    @Test
    public void testLast() {
        LinkedList list = new LinkedList();
        list.prepend(3);
        list.prepend(2);
        list.prepend(1);

        assertEquals(list.last(), 3);
    }

    @Test
    public void testLength() {
        LinkedList list = new LinkedList();
        list.prepend(3);
        list.prepend(2);
        list.prepend(1);
        
        assertEquals(list.length(), 3);
    }

    @Test
    public void testToString() {
        LinkedList list = new LinkedList();
        list.prepend(3);
        list.prepend(2);
        list.prepend(1);
        
        assertEquals(list.toString(), "1 2 3 ");
    }

    @Test
    public void testFirst() {
        LinkedList list = new LinkedList();
        list.prepend(3);
        list.prepend(2);
        list.prepend(1);
        
        assertEquals(list.first(), 1);
    }

    @Test
    public void testAppend() {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        
        assertEquals(list.first(), 1);
    }
}
