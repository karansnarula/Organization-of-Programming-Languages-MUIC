import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GenericNestedList<String> lst = new GenericNestedList<String>("test");
        System.out.println(lst.getBaseValue());

    }
    public static class GenericNestedList<E> implements NestedList {

        List<E> list = new ArrayList();

        public GenericNestedList(E element){
            list.add(element);
        }

        @Override
        public boolean isBase() {
            if(list.get(0).getClass().getName().equals("java.util.ArrayList")){
                return false;
            }
            return true;
        }

        @Override
        public E getBaseValue() {
            if(isBase()){
                return list.get(0);
            }
            return null;
        }

        @Override
        public List<NestedList> getList() {
            if(!isBase()){
                return (List<NestedList>) list;
            }
            return null;
        }
    }
}
