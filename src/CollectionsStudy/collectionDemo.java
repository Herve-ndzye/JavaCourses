package CollectionsStudy;

import java.util.*;

import static java.util.Collections.sort;

public class collectionDemo {
    public static void main(String[] args){
        List<Integer> c = new ArrayList<>();
        c.add(15);
        c.add(12);
        c.add(37);
        c.add(13);
        c.add(66);
        c.sort((a, b) -> (a%10)-(b%10));
        System.out.println(c);
        for(Integer a : c){
            System.out.println(a*2);
        }
        Iterator<Integer> it = c.iterator();
        while(it.hasNext()){
            System.out.println(it.next()*2);
        }
        Collections.sort(c);
        System.out.println("sorted : "+c);
        c.get(1);
        c.remove(0);
    }
}
