import org.junit.jupiter.api.Test;

import javafx.util.Pair;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TestGenericNestedList {
    @Test
    void testSingleNestedList() {
        Iterator<Pair<String, Integer>> testIter = new GenericNestedList<>(Arrays.asList(
                new GenericNestedList<>("a"),
                new GenericNestedList<>(Arrays.asList(
                        new GenericNestedList<>("b"),
                        new GenericNestedList<>("c"),
                        new GenericNestedList<>(Arrays.asList(
                                new GenericNestedList<>("d"),
                                new GenericNestedList<>("e"),
                                new GenericNestedList<>("fgh")
                        ))
                ))
        )).iterator();
        List<Pair<String,Integer>> correctPairs = Arrays.asList(
                new Pair<>("a", 1),
                new Pair<>("b", 2),
                new Pair<>("c", 2),
                new Pair<>("d", 3),
                new Pair<>("e", 3),
                new Pair<>("fgh", 3)
        );
        for (Pair<String, Integer> correctPair : correctPairs) {
            Pair<String, Integer> testPair = testIter.next();
            assertEquals(correctPair, testPair);
        }
        assertThrows(NoSuchElementException.class, () -> testIter.next());
    }

    @Test
    void testMultipleNestedList() {
        Iterator<Pair<Integer, Integer>> testIter = new GenericNestedList<>(Arrays.asList(
                new GenericNestedList<>(Arrays.asList(
                        new GenericNestedList<>(100),
                        new GenericNestedList<>(200)
                )),
                new GenericNestedList<>(7),
                new GenericNestedList<>(Arrays.asList(
                        new GenericNestedList<>(9),
                        new GenericNestedList<>(2),
                        new GenericNestedList<>(Arrays.asList(
                                new GenericNestedList<>(11),
                                new GenericNestedList<>(13)
                        ))
                )),
                new GenericNestedList<>(1)
        )).iterator();
        List<Pair<Integer,Integer>> correctPairs = Arrays.asList(
                new Pair<>(100, 2),
                new Pair<>(200, 2),
                new Pair<>(7, 1),
                new Pair<>(9, 2),
                new Pair<>(2, 2),
                new Pair<>(11, 3),
                new Pair<>(13, 3),
                new Pair<>(1, 1)
        );
        for (Pair<Integer, Integer> correctPair : correctPairs) {
            Pair<Integer, Integer> testPair = testIter.next();
            assertEquals(correctPair, testPair);
        }
        assertThrows(NoSuchElementException.class, () -> testIter.next());
    }

    @Test
    void testDepthZero() {
        Iterator<Pair<String, Integer>> testIter = new GenericNestedList<>("Zero").iterator();
        Pair<String, Integer> testPair = testIter.next();
        assertEquals(new Pair<>("Zero", 0), testPair);
        assertThrows(NoSuchElementException.class, () -> testIter.next());
    }
}