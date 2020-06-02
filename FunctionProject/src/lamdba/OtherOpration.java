package lamdba;

import java.util.Optional;
import java.util.stream.Stream;

/**
 *  其它操作
 */
public class OtherOpration {

    public static void main(String[] args) {
        Stream<String> list = Stream.of("Orange", "apple", "Banana");
        Optional<String> any = list.findAny();

        System.out.println(any);
    }
}
