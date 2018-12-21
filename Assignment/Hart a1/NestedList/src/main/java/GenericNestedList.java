import javafx.util.Pair;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class GenericNestedList<E> implements NestedList<E>, Iterable<Pair<E, Integer>>{
    private E obj = null;
    private List<NestedList<E>> objNested = null;
    private NestedList<E> selfPointer;

    public GenericNestedList(E obj) {
        this.obj = obj;
        this.selfPointer = this;
    }

    public GenericNestedList(List<NestedList<E>> objNested) {
        this.objNested = objNested;
        this.selfPointer = this;
    }

    @Override
    public boolean isBase() {
        return (objNested == null);
    }

    @Override
    public E getBaseValue() {
        if (!isBase()) {
            throw new IllegalStateException();
        }
        return obj;
    }

    @Override
    public List<NestedList<E>> getList() {
        if (isBase()) {
            throw new IllegalStateException();
        }
        return objNested;
    }

    private class GenericNestedListIterator implements Iterator<Pair<E, Integer>> {
        private BlockingQueue<Pair<E, Integer>> blockingQueue = new LinkedBlockingDeque<>(1);
        private boolean isFinished = false; // Helps prevent race condition vs just checking remainingCapacity of queue

        private <E> void walkNested(NestedList<E> list, int depth) {
            if (list.isBase()) {
                try {
                    blockingQueue.put(new Pair(list.getBaseValue(), depth));
                } catch (InterruptedException e) {
                    // Do nothing
                }
            }
            else {
                for (NestedList<E> member: list.getList())
                    walkNested(member, depth + 1);
            }
        }

        public GenericNestedListIterator() {
            if (selfPointer.isBase()) {
                try {
                    blockingQueue.put(new Pair(selfPointer.getBaseValue(), 0));
                    isFinished = true;
                } catch (InterruptedException e) {
                    // Do nothing
                }
            }
            else {
                new Thread(() -> {
                    walkNested(selfPointer, 0);
                    isFinished = true;
                }).start();
            }
        }

        @Override
        public boolean hasNext() {
            return !(isFinished && blockingQueue.remainingCapacity() == 1);
        }

        @Override
        public Pair<E, Integer> next() {
            if (hasNext()) {
                try {
                    return blockingQueue.take();
                } catch (InterruptedException e) {
                    return null;
                }
            }
            throw new NoSuchElementException();

        }

    }

    @Override
    public Iterator<Pair<E, Integer>> iterator() {
        return new GenericNestedListIterator();
    }
}
