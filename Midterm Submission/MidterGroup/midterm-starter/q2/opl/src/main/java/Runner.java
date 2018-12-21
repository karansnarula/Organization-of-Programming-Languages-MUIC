import java.util.Iterator;

public class Runner {
    public static void main(String[] args) {
        IteratorTTT.EnhancedTTT t = new IteratorTTT.EnhancedTTT(3);
        Iterator<String> it = IteratorTTT.allEndgame(3).iterator();
        for (Iterator<String> it1 = it; it1.hasNext(); ) {
            String aT = it1.next();
            System.out.println(aT);
        }
//        String aT = it.next();
//        System.out.println(aT);


    }
}
