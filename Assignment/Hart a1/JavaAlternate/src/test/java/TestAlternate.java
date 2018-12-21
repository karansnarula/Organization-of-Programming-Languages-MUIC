import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestAlternate {
    @Test
    void testEqualIterators() {
        List<Integer> it1 = Arrays.asList(3,5,9);
        List<Integer> it2 = Arrays.asList(4,1,6);
        Iterator testIter = new Alternate<>(it1, it2).iterator();
        List<Integer> correctValues = Arrays.asList(3,4,5,1,9,6);
        for (Integer correctValue : correctValues) {
            assertTrue(testIter.hasNext());
            assertEquals(correctValue, testIter.next());
        }
        assertFalse(testIter.hasNext());
        assertThrows(NoSuchElementException.class, () -> testIter.next());
    }

    @Test
    void testUnequalIterators() {
        List<Integer> it1 = Arrays.asList(1,3,5,7,8,9);
        List<Integer> it2 = Arrays.asList(2,4,6);
        Iterator testIter = new Alternate<>(it1, it2).iterator();
        List<Integer> correctValues = Arrays.asList(1,2,3,4,5,6,7,8,9);
        for (Integer correctValue : correctValues) {
            assertTrue(testIter.hasNext());
            assertEquals(correctValue, testIter.next());
        }
        assertFalse(testIter.hasNext());
        assertThrows(NoSuchElementException.class, () -> testIter.next());
    }

    @Test
    void testOneEmptyIterator() {
        List<Integer> it1 = Arrays.asList();
        List<Integer> it2 = Arrays.asList(11,3,7);
        Iterator testIter = new Alternate<>(it1, it2).iterator();
        List<Integer> correctValues = Arrays.asList(11, 3, 7);
        for (Integer correctValue : correctValues) {
            assertTrue(testIter.hasNext());
            assertEquals(correctValue, testIter.next());
        }
        assertFalse(testIter.hasNext());
        assertThrows(NoSuchElementException.class, () -> testIter.next());
    }

    @Test
    void testTwoEmptyIterators() {
        List<Integer> it1 = Arrays.asList();
        List<Integer> it2 = Arrays.asList();
        Iterator testIter = new Alternate<>(it1, it2).iterator();
        assertFalse(testIter.hasNext());
        assertThrows(NoSuchElementException.class, () -> testIter.next());
    }

    @Test
    void testDiffTypesIterators() {
        List<Object> it1 = Arrays.asList("a", "b", "c");
        List<Object> it2 = Arrays.asList(1,2,3);
        List<Object> correctValues = Arrays.asList("a",1,"b",2,"c",3);
        Iterator testIter = new Alternate<>(it1, it2).iterator();
        for (Object correctValue : correctValues) {
            assertTrue(testIter.hasNext());
            assertEquals(correctValue, testIter.next());
        }
        assertFalse(testIter.hasNext());
        assertThrows(NoSuchElementException.class, () -> testIter.next());
    }
}
