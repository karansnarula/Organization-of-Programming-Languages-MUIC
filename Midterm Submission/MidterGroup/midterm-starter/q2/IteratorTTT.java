import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class IteratorTTT {

    static class EnhancedTTT extends TicTacToe implements Iterable<String>{

        private BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
        TicTacToe t;
        Queue<String> q = new LinkedList<>();
        Boolean started = false;
        // TODO: feel free to change the constructor

        EnhancedTTT(int n) {
            super(n);
            t = this;
        }

        @Override
        void reportFound(String sol) {
            // TODO: Do the right thing
                q.add(sol);
                return;

        }

        @Override
        public Iterator<String> iterator() {
            return new MyIterator();
        }

        public class MyIterator implements Iterator<String> {

            private ThreadRunner threadRunner = new ThreadRunner();
            private Thread thread = new Thread(threadRunner);

            MyIterator() {
            }

            @Override
            public boolean hasNext() {
                return !queue.isEmpty()||!threadRunner.finished;

            }

            @Override
            public String next() throws NoSuchElementException {
//                Thread t = new Thread();



                if (!hasNext()) {
                    System.exit(1);
                    throw new NoSuchElementException();
                }
                if (!started) {
                    thread.start();
                    started = true;
                }
                try {
                    return queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            private class ThreadRunner implements Runnable {

                Boolean finished = false;
                Boolean started = false;

                ThreadRunner() {
                }

                @Override
                public void run() {
                    started = true;
                    t.run();
                    while(!q.isEmpty()){
                        try {
                            queue.put(q.poll());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    finished = true;
                    return;
                }
            }

        }


    }

    public static Iterable<String> allEndgame(int n) {
        // TODO: implement me using the set up above
        return new EnhancedTTT(n);
    }
}


