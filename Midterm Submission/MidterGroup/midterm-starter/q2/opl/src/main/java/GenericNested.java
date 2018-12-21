//import javafx.util.Pair;
//
//import java.util.Iterator;
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;
//
//public class GenericNested<E> implements NestedList<E> , Iterable<Pair<E, Integer>>{
//
//    private BlockingQueue<Pair<E, Integer>> queue = new ArrayBlockingQueue<>(1);
//    private E item;
//    private List<NestedList<E>> list;
//    private boolean isBase;
//
//    GenericNested(E item){
//        this.item = item;
//        this.isBase = true;
//    }
//
//    GenericNested(List<NestedList<E>> list){
//        this.list = list;
//        this.isBase = false;
//    }
//
//    @Override
//    public boolean isBase() {
//        return this.isBase;
//    }
//
//    @Override
//    public E getBaseValue() throws  IllegalStateException{
//        if( this.isBase ){
//            return item;
//        }else{
//            throw new IllegalStateException();
//        }
//    }
//
//    @Override
//    public List<NestedList<E>> getList() {
//        if( !this.isBase ){
//            return list;
//        }else{
//            throw new IllegalStateException();
//        }
//    }
//
//    private void walkNested(NestedList<E> list, int depth) throws InterruptedException {
//        if (list.isBase()){
////            System.out.printf("%d: %s\n", depth, list.getBaseValue().toString());
//            queue.put(new Pair<>(list.getBaseValue(),depth));
//        }else{
//            for (NestedList<E> member: list.getList()){
//                walkNested(member,depth+1);
//            }
//        }
//    }
//
//
//    @Override
//    public Iterator<Pair<E, Integer>> iterator() {
//        return new MyIterator();
//    }
//
//    private class ThreadRunner implements Runnable {
//
//        Boolean finished = false;
//        Boolean started = false;
//
//        ThreadRunner(){
//
//        }
//
//        @Override
//        public void run() {
//            started = true;
//            for (NestedList<E> l : list){
//                try {
//                    walkNested(l,0);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            finished = true;
//        }
//    }
//
//}
