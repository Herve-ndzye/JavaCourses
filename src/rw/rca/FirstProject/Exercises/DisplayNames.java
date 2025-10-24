package rw.rca.FirstProject.Exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.reverseOrder;

public class DisplayNames {
    public static void main(String[] args){
        List<String> Names = new ArrayList<>();
        Names.add("Herve");
        Names.add("Mucyo");
        Names.add("Nziza");
        Names.add("Michael");
        Names.add("Prince");
        Names.remove(2);
        for(String a : Names) System.out.println(a);
    }
}
class ReversingList{
    public static void main(String[] args){
        List<Integer> nums = new ArrayList<>();
        nums.add(24);
        nums.add(12);
        nums.add(70);
        nums.add(45);
        nums.add(70);
        nums.add(45);
        Collections.sort(nums);
        System.out.println(nums);
        Collections.sort(nums,reverseOrder());
        System.out.println(nums);
        List<Integer> toPrint = new ArrayList<>();
    }
}
