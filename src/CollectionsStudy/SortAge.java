package CollectionsStudy;

import java.util.Comparator;

public class SortAge implements Comparator<Employee> {

    @Override
    public int compare(Employee em1, Employee em2) {
        return Integer.compare(em1.getAge(),em2.getAge());
    }
}
