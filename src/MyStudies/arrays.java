package MyStudies;

import java.text.NumberFormat;
import java.util.Arrays;

public class arrays {
    public static void main(String[] args){
        int[][] numbers = {{1,3,5},{2,6,8}};
        System.out.println(Arrays.deepToString(numbers));
    }
}
class variables{
    public static void main(String[] args){
        double result = (double)10/(double)5;
        String num = "12";
        double y = Double.parseDouble(num) + 23;
        String out = NumberFormat.getCurrencyInstance().format(12.000);
        String percent = NumberFormat.getPercentInstance().format(0.2);
        //String fromNum = (String) 12;
        System.out.println(percent);
    }
}
