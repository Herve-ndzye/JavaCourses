package rw.rca.FirstProject.examples;

import java.util.*;

public class FirstProgram {
    public static void main(String[] args) {
        Set<String> districts = new TreeSet<String>();
        districts.add("Nyabihu");
        districts.add("Rubavu");
        districts.add("Rubavu");
        districts.add("Gasabo");
        districts.add("Kamonyi");
        districts.add("Rusizi");

        for(String district:districts){
            System.out.println(district);
        }
     }
}
