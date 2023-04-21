import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.*;

public class ListTests {
    @Test
    public void testFilter() {
        lazy LAZY = new lazy();
        List<String> list = new ArrayList<>();
        List<String> output = new ArrayList<>();
        list.add("tatis1");
        list.add("tatis2");
        list.add( "tatis3");
        output = ListExamples.filter(list, LAZY);
        assertEquals(output.get(0), "tatis1");
    }

    @Test
    public void testMerge() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list1.add("a");
        list1.add("c");
        list1.add("d");

        list2.add("b");
        list2.add("c");
        list2.add("e");
        List<String> output = ListExamples.merge(list1, list2);
        assertArrayEquals(new String[]{"a", "b", "c", "c", "d", "e"}, output.toArray());
    }
}
