package OtherOprate.max;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * max
 * 获取日期中最大值
 */
public class MaxDemo1 {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        Stream<String> data = Stream.of("2020-01-01 01:10:10", "2020-01-01 01:10:11", "2020-01-01 01:12:10", "2020-01-01 01:20:10");
        String s = data.max(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int tag = 0;
                try {
                    if (sdf.parse(o1).getTime() > sdf.parse(o2).getTime()) {
                        tag = 1;
                    } else if (sdf.parse(o1).getTime() < sdf.parse(o2).getTime()) {
                        tag = -1;
                    } else {
                        tag = 0;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return tag;
            }
        }).get();

        System.out.println(s);

    }
}
