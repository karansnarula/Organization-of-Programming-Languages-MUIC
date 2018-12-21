import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> it1 = Arrays.asList(1,2,3,100,110,120);
        List<Integer> it2 = Arrays.asList(4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        for (Integer e: new Alternate<>(it1, it2)) {
            System.out.println(e);
        }
    }

    public static class Alternate<E> implements Iterable<E>{
        List<E> list = new ArrayList<>();

        @Override
        public Iterator<E> iterator() {
            return list.iterator();
        }

        public Alternate(List<E> iter1, List<E> iter2){
            int size;
            if(iter1.size() > iter2.size()){
                size = iter1.size();
            }else{
                size = iter2.size();
            }
            int index = 0;
            try {
                while(index < size){
                    if(index < iter1.size()){
                        list.add(iter1.get(index));
                    }
                    if(index < iter2.size()){
                        list.add(iter2.get(index));
                    }
                    index++;
                }
            }catch (ArrayIndexOutOfBoundsException ignore){

            }
        }
    }
}
