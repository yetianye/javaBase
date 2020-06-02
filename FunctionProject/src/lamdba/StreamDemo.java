package lamdba;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        Stream<String> a = Stream.of("123","23","32");
        a.forEach((c)-> System.out.println(c));
        a.forEach(System.out::print);
    }
}

class MapDemo{
    /**
     * 将字符串去除空格
     * @param args
     */
    public static void main(String[] args) {
        String[] array = new String[] { " 2019-12-31 ", "2020 - 01-09 ", "2020- 05 - 01 ", "2022 - 02 - 01",
                " 2025-01 -01" };


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = simpleDateFormat.parse("2019-12-31");
            LocalDate localDate = parse.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            Arrays.stream(array)
                    .map((a)->a.replace(" ",""))
                    .map(LocalDate::parse)
                    .forEach(System.out::println);


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

