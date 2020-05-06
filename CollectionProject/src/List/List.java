package List;

import java.util.Arrays;

public class List {
    public static void main(String[] args) {
        java.util.List<String> list = Arrays.asList("asd", "sddd", "asdfgg");

        for (java.util.Iterator<String> it =list.iterator();it.hasNext();) {
            System.out.println(it.next());
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}
