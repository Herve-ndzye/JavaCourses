package MyStudies.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexIntro {
    public static void main(String[] args){
        Pattern pattern = Pattern.compile(".ca");
        Matcher matcher = pattern.matcher("rca");
        boolean result = matcher.matches();
        System.out.println(result);
        boolean res2 = Pattern.compile(".ca").matcher("rca").matches();
        System.out.println(res2);
        System.out.println(Pattern.matches(".ca","rca"));
        System.out.println(Pattern.matches("[amn]","am"));
        Pattern p1 = Pattern.compile("\\d+");
        Matcher m1 = p1.matcher("123hhh456");
        while(m1.find()){
            System.out.println(m1.group());
        }
    }
}
