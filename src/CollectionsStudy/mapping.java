package CollectionsStudy;

import java.util.HashMap;
import java.util.Map;

public class mapping {
    public static void main(String[] args){
        Map<String,Integer> marks = new HashMap<>();
        marks.put("Aloys",90);
        marks.put("Tresor",90);
        marks.put("Arlene",99);
        marks.put("Aloys",95);
        System.out.println(marks);
    }
}
