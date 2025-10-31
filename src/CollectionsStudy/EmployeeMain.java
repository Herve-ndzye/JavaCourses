package CollectionsStudy;

import java.util.*;

public class EmployeeMain {
    public static void main(String[] args){
        Set<Employee> set = new HashSet<>();
        Employee em1 = new Employee("Herve","Ndizeye",20,30000);
        Employee em2 = new Employee("Herve","Ndizeye",20,30000);
        set.add(em1);
        set.add(em2);
        set.add(new Employee("Herve","Ndizeye",20,30000));
        set.add(new Employee("Brian","Muhizi Lilian",9,100));
        set.add(new Employee("Bana","Tresor",12,300));
        boolean test = em1.equals(em2);
        System.out.println(test);

//        Comparator<Employee> com = new Comparator<Employee>(){
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return 0;
//            }
//        };
//        list.sort(com);
//        System.out.println(list);
    }
}
class wildCardsJava{
    public static void main(String[] args){
        List<Integer> list1 = Arrays.asList(2,35,67);
        List<String> list2 = Arrays.asList("Nana","Lala");
        display(list1);
    }
    public static void display(List<? super Integer> list){
        for(Object obj : list){
            System.out.println(obj);
        }
    }
}
