import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Alternate<E> implements Iterable<E> {
    private Iterator<E> it1Iterator;
    private Iterator<E> it2Iterator;

    public Alternate(Iterable<E> it1, Iterable<E> it2) {
        it1Iterator = it1.iterator();
        it2Iterator = it2.iterator();
    }

    /**
     * AlternateIterator puts the two iterator into a list
     * and then keep track of the iterator to get next element
     * from using currentIterIndex
     */
    private class AlternateIterator implements Iterator<E> {
        private List<Iterator<E>> iterables;
        private int currentIterIndex = 0;

        public AlternateIterator() {
            iterables = Arrays.asList(it1Iterator, it2Iterator);
            if (!it1Iterator.hasNext()) currentIterIndex = 1; // required for hasNext()
        }

        @Override
        public boolean hasNext() {
            return iterables.get(currentIterIndex).hasNext();
        }

        /**
         * next() will return the next object from both iterators alternatingly
         * by adjusting currentIterIndex, until one iterator has no more elements
         * and then it'll return only from the other iterator
         * (and throw NoSuchElementException if the other iterator also has no more elements)
         */
        @Override
         public E next() {
            E toReturn = iterables.get(currentIterIndex).next();
            int newCurrentIterIndex = currentIterIndex ^ 1; // Flip 1 to 0 and vice versa
            // Ensure Alternate works for two iterators of unequal size
            if (iterables.get(newCurrentIterIndex).hasNext()) {
                currentIterIndex = newCurrentIterIndex;
            }
            return toReturn;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new AlternateIterator();
    }
}
