package List;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class List {
    public static void main(String[] args) {
        java.util.List<String> list = Arrays.asList("asd", "sddd", "asdfgg");

        for (java.util.Iterator<String> it = list.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }

        for (String s : list) {
            System.out.println(s);
        }

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

        TreeMap treeMap = new TreeMap();

       Thread t = new  Thread();
        t.run();
        t.start();

    }
}
