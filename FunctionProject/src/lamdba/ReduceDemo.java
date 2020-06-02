package lamdba;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceDemo {
    public static void main(String[] args) {
        /*Double reduce = Stream.of(13.2, 23.32).reduce(1.0, (acc, n) -> acc * n);
        System.out.println(reduce);*/

        // 按行读取配置文件:
        List<String> props = Arrays.asList("profile=native", "debug=true", "logging=warn", "interval=500");

        props.stream().map(ky -> {
            String[] split = ky.split("=");
            return Collections.singletonMap(split[0], split[1]);
        }).reduce(new HashMap<String, String>(), (map, ky) -> {
            map.putAll(ky);
            return map;
        }).forEach((k,v)-> System.out.println(v));

        //reduce.forEach((k,v)-> System.out.println("k:" + k + "-" + "v:"+ v));
    }
}

class reduceDemo2{
    public static void main(String[] args) {
//        将一组String先过滤掉空字符串，然后把非空字符串保存到List中：

        Stream<String> data = Stream.of("asdsd", "asd asd", " asd asd");

        data.map(n -> {
            List<String> temp = new ArrayList<String>();
            temp.add(n.replace(" ", ""));
            return temp;
        }).reduce(new ArrayList<String>(), (l, str) -> {
            l.addAll(str);
            return l;
        });

    }
}
